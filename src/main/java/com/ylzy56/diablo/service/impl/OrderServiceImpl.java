package com.ylzy56.diablo.service.impl;

import com.ylzy56.diablo.domain.Order;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> findAll() {
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
    public Order findById(int orderId) {
        return null;
    }

    @Override
    public void save(Order order) {

    }

    @Override
    public void delete(int orderId) {

    }

    @Override
    public void update(Order order) {

    }
}
