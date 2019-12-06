package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.AddressMapper;
import com.ylzy56.diablo.dao.RoleMapper;
import com.ylzy56.diablo.dao.RolePermissionMapper;
import com.ylzy56.diablo.dao.UserRoleMapper;
import com.ylzy56.diablo.domain.*;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.AddressService;
import com.ylzy56.diablo.service.PermissionService;
import com.ylzy56.diablo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired(required = false)
    private AddressMapper addressMapper;


    @Override
    public List<Address> findAll() {
        return addressMapper.selectAll();
    }

    @Override
    public Address findById(int id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int save(Address address) {
        return addressMapper.insert(address);
    }

    @Override
    public int delete(int id) {
        Address address = findById(id);
        if (ObjectUtils.isEmpty(address)){
            throw new RuntimeException("不存在这条数据");
        }

        return 0;
    }

    @Override
    public int update(Address address) {
        return addressMapper.updateByPrimaryKey(address);
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
            address.setCreated(lo.get(7));
            addressMapper.insert(address);
        }






    }

    @Override
    public PageResult searchPage(String keyword, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
//        if (keyword != null && keyword.length() > 0) {
//            criteria.orLike("username", "%" + keyword + "%").orLike("mobile", "%" + keyword + "%");
//        }
        Page<Address> page = (Page<Address>) addressMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult searchNoPage(String keyword) {
        Example example = new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
//        if (keyword != null && keyword.length() > 0) {
//            criteria.orLike("username", "%" + keyword + "%").orLike("mobile", "%" + keyword + "%");
//        }
        Page<Address> page = (Page<Address>) addressMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
