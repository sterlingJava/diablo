package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Customer;
import com.ylzy56.diablo.domain.Order;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    PageResult findPage(Integer pageNum, Integer pageSize);

    PageResult searchPage(Condition condition,String enterpriseId);

    Order findById(String orderId);

    void save(Order order);

    void delete(String orderId);

    void update(Order order);

    boolean checkUserStatus(String orderId);
}
