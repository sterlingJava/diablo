package com.ylzy56.diablo.service.impl;

import com.ylzy56.diablo.domain.Order;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
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
    public Order findById(String orderId) {
        return null;
    }

    @Override
    public void save(Order order) {

    }

    @Override
    public void delete(String orderId) {

    }

    @Override
    public void update(Order order) {

    }
}
