package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Customer;
import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    PageResult findPage(int pageNum, int pageSize);

    PageResult searchPage(Condition condition, int pageNum, int pageSize);

    Customer findById(int customerId);

    void save(Customer customer);

    void delete(int customerId);

    void update(Customer customer);

    PageResult searchCustomerList(Condition condition);
}
