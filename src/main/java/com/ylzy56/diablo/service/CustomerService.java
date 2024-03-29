package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Customer;
import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    PageResult findPage(Integer pageNum, Integer pageSize);

    Customer findById(String customerId);

    void save(Customer customer);

    void delete(String customerId);

    void update(Customer customer);

    List<Customer> findCustomersByOrderId(String orderId);

    PageResult searchCustomerList(Condition condition);

    PageResult searchPage(Condition condition, String enterpriseId);
}
