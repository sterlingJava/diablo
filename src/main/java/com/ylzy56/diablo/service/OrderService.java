package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Order;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    PageResult findPage(int pageNum, int pageSize);

    PageResult searchPage(Condition condition, int pageNum, int pageSize);

    Order findById(int orderId);

    void save(Order order);

    void delete(int orderId);

    void update(Order order);
}
