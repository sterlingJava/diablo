package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.*;
import com.ylzy56.diablo.domain.*;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.AddressService;
import com.ylzy56.diablo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired(required = false)
    private AddressMapper addressMapper;

    @Autowired
    private OrderService orderService;

    @Autowired(required = false)
    private OrderAddressMapper orderAddressDao;


    @Override
    public List<Address> findAll() {
        Example example = new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel", 0);
        return addressMapper.selectByExample(example);
    }

    @Override
    public Address findById(String id) {
        //1.根据id查询地址信息
        Example example = new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("addressId", id);
        criteria.andEqualTo("isDel", "0");
        return addressMapper.selectOneByExample(example);
    }

    @Override
    public void save(Address address) {
        address.setSource("0");
        address.setIsDel("0");
        address.setCreateTime(new Date());
        addressMapper.insertSelective(address);
    }

    @Override
    public void update(Address address) {
        address.setLastModifyTime(new Date());
        addressMapper.updateByPrimaryKey(address);
    }

    @Override
    public PageResult searchPage(Condition condition, String enterpriseId) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        Example example = new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmpty(condition.getKeyword())) {
            criteria.orLike("ENTERPRISE_NAME", "%" + condition.getKeyword() + "%");
        }
        if (!StringUtil.isEmpty(condition.getStatus())) {
            criteria.andEqualTo("status", condition.getStatus());
        }
        Example.Criteria exampleCriteria = example.createCriteria();
        exampleCriteria.andEqualTo("isDel", "0");
        exampleCriteria.andEqualTo("enterpriseId", enterpriseId);
        example.and(exampleCriteria);
        Page<Address> page = (Page<Address>) addressMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Address> searchNoPage(String keyword) {
        Example example = new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
        if (keyword != null && keyword.length() > 0) {
//            criteria.orLike("username", "%" + keyword + "%").orLike("mobile", "%" + keyword + "%");
        }
        return addressMapper.selectByExample(example);
    }

    @Override
    public List<Address> findAddressByOrderId(String orderId) {
        List<Address> addressList = new ArrayList<>();
        if (orderService.checkUserStatus(orderId)) {
            //1.从用户角色关联表中查询出用户的角色id列表
            List<OrderAddress> orderAddressList = orderAddressDao.select(new OrderAddress() {{
                setOrderId(orderId);
            }});
            //2.根据角色id列表,查询角色详情
            for (OrderAddress orderAddress : orderAddressList) {
                Example example = new Example(Address.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("addressId", orderAddress.getAddressId());
                criteria.andEqualTo("isDel", "0");
                Address address = addressMapper.selectOneByExample(example);
                addressList.add(address);
            }
        }
        return addressList;
    }

    @Override
    public void delete(String id) {
        Address address = findById(id);
        if (ObjectUtils.isEmpty(address)) {
            throw new RuntimeException("不存在这条数据");
        }
        address.setIsDel("1");
        update(address);
    }

    @Override
    public void lead(List<List<String>> list) {

        for (int i = 0; i < list.size(); i++) {
            List<String> lo = list.get(i);
            int size = list.get(i).size();//长度

            Address address = new Address();
            address.setEnterpriseName(lo.get(1));
            address.setLinkman(lo.get(2));
            address.setPhone(lo.get(3));
            address.setAddressType(lo.get(4));
            address.setArea(lo.get(5));
            address.setDetailedAddress(lo.get(6));
            address.setSource(lo.get(7));
            save(address);
        }


    }
}
