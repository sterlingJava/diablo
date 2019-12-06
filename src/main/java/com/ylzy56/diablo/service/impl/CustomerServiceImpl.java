package com.ylzy56.diablo.service.impl;

import com.ylzy56.diablo.domain.Customer;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.CustomerService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public PageResult searchPage(Condition condition, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public Customer findById(int customerId) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void delete(int customerId) {

    }

    @Override
    public void update(Customer customer) {

    }
}
