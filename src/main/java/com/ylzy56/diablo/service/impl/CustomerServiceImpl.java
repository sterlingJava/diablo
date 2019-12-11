package com.ylzy56.diablo.service.impl;

import com.ylzy56.diablo.domain.Customer;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> findAll() {
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
    public PageResult searchPage(Condition condition, Integer pageNum, Integer pageSize) {
        if (ObjectUtils.isEmpty(pageNum)){
            pageNum=1;
        }
        if (ObjectUtils.isEmpty(pageSize)){
            pageSize=10;
        }
        return null;
    }

    @Override
    public Customer findById(String customerId) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void delete(String customerId) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public PageResult searchCustomerList(Condition condition) {
        return null;
    }
}
