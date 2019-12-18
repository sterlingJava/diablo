package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.common.utils.RandomStringUtils;
import com.ylzy56.diablo.common.utils.StringRandomUtils;
import com.ylzy56.diablo.common.utils.StringTimeUtils;
import com.ylzy56.diablo.dao.OrderAddressMapper;
import com.ylzy56.diablo.dao.OrderCustomerMapper;
import com.ylzy56.diablo.dao.OrderMapper;
import com.ylzy56.diablo.domain.*;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.AddressService;
import com.ylzy56.diablo.service.CustomerService;
import com.ylzy56.diablo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired(required = false)
    private OrderMapper orderDao;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CustomerService customerService;

    @Autowired(required = false)
    private OrderAddressMapper orderAddressDao;

    @Autowired(required = false)
    private OrderCustomerMapper orderCustomerDao;

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public PageResult findPage(Integer pageNum, Integer pageSize) {
        if (ObjectUtils.isEmpty(pageNum)){
            pageNum=1;
        }
        if (ObjectUtils.isEmpty(pageSize)){
            pageSize=10;
        }
        return null;
    }

    @Override
    public PageResult searchPage(Condition condition,String enterpriseId) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmpty(condition.getKeyword())) {
            criteria.orLike("ENTERPRISE_NAME", "%" + condition.getKeyword() + "%");
        }
        if (!StringUtil.isEmpty(condition.getStatus())){
            criteria.andEqualTo("status",condition.getStatus());
        }
        Example.Criteria exampleCriteria = example.createCriteria();
        exampleCriteria.andEqualTo("isDel","0");
        exampleCriteria.andEqualTo("enterpriseId",enterpriseId);
        example.and(exampleCriteria);
        Page<Order> page = (Page<Order>) orderDao.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public Order findById(String orderId) {
        //1.根据id查询企业信息
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId",orderId);
        criteria.andEqualTo("isDel","0");
        Order order = orderDao.selectOneByExample(example);
        List<Address> addressList = addressService.findAddressByOrderId(orderId);
        if (!ObjectUtils.isEmpty(order)) {
            if (!ObjectUtils.isEmpty(addressList)) {
                order.setAddressList(addressList);
            }
            Customer customer = customerService.findById(order.getCustomerId());
            if (!ObjectUtils.isEmpty(customer)) {
                order.setCustomer(customer);
            }
        }

        return order;
    }

    @Override
    public void save(Order order) {
        if (ObjectUtils.isEmpty(order.getCustomerId())) {
            if (!ObjectUtils.isEmpty(order.getCustomer())) {
                customerService.save(order.getCustomer());
                order.setCustomerId(order.getCustomer().getCustomerId());
            }
        }
        String orderId = "KHDD"+ StringTimeUtils.getTimeString()+ RandomStringUtils.randomNumeric(6);
        order.setOrderId(orderId);
        order.setCreateTime(new Date());
        order.setIsDel("0");
        orderDao.insertSelective(order);


        if (!ObjectUtils.isEmpty(order.getAddressList())){
            for (Address address : order.getAddressList()) {
                if (ObjectUtils.isEmpty(address.getAddressId())){
                    addressService.save(address);
                }
                OrderAddress orderAddress = new OrderAddress();
                orderAddress.setAddressId(address.getAddressId());
                orderAddress.setOrderId(order.getOrderId());
                orderAddressDao.insertSelective(orderAddress);
            }
        }

    }

    @Override
    public void delete(String orderId) {
        //1.删除用户角色关联表信息
        orderCustomerDao.delete(new OrderCustomer() {{
            setOrderId(orderId);
        }});
        orderAddressDao.delete(new OrderAddress() {{
            setOrderId(orderId);
        }});
        //2.查询需要删除的用户
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId",orderId);
        criteria.andEqualTo("isDel","0");
        Order order = orderDao.selectOneByExample(example);
        if (!ObjectUtils.isEmpty(order)) {
            order.setIsDel("1");
            //2.删除用户信息
            orderDao.updateByPrimaryKeySelective(order);
        }
    }

    @Override
    public void update(Order order) {
        order.setLastModifyTime(new Date());
        orderDao.updateByPrimaryKeySelective(order);
    }

    @Override
    public boolean checkUserStatus(String orderId) {
        //1.根据id查询订单信息
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId",orderId);
        criteria.andEqualTo("isDel","0");
        Order order = orderDao.selectOneByExample(example);
        if (ObjectUtils.isEmpty(order)){
            return false;
        }else {
            return true;
        }
    }
}
