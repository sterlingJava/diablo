package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.CustomerMapper;
import com.ylzy56.diablo.dao.OrderCustomerMapper;
import com.ylzy56.diablo.domain.*;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.CustomerService;
import com.ylzy56.diablo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired(required = false)
    private CustomerMapper customerDao;

    @Autowired
    private OrderService orderService;

    @Autowired(required = false)
    private OrderCustomerMapper orderCustomerDao;

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
    public PageResult searchPage(Condition condition,String enterpriseId) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        Example example = new Example(Customer.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmpty(condition.getKeyword())) {
            criteria.orLike("abbreviation", "%" + condition.getKeyword() + "%");
            criteria.orLike("fullName", "%" + condition.getKeyword() + "%");
        }
        if (!StringUtil.isEmpty(condition.getStatus())){
            criteria.andEqualTo("status",condition.getStatus());
        }
        Example.Criteria exampleCriteria = example.createCriteria();
        exampleCriteria.andEqualTo("isDel","0");
        exampleCriteria.andEqualTo("enterpriseId",enterpriseId);
        example.and(exampleCriteria);
        Page<Customer> page = (Page<Customer>) customerDao.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public Customer findById(String customerId) {
        //1.根据id查询客户信息
            Example example = new Example(Customer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("customerId",customerId);
        criteria.andEqualTo("status","0");
        criteria.andEqualTo("isDel","0");
        return customerDao.selectOneByExample(example);
    }

    @Override
    public void save(Customer customer) {
        customer.setSource("0");
        customer.setCreateTime(new Date());
        customer.setIsDel("0");
        customerDao.insertSelective(customer);
    }

    @Override
    public void delete(String customerId) {
        Customer customer = findById(customerId);
        if (!ObjectUtils.isEmpty(customer)){
            customer.setIsDel("1");
            update(customer);
        }
    }

    @Override
    public void update(Customer customer) {
        customer.setLastModifyTime(new Date());
        customerDao.updateByPrimaryKeySelective(customer);
    }

    @Override
    public List<Customer> findCustomersByOrderId(String orderId) {
        List<Customer> addressList = new ArrayList<>();
        if (orderService.checkUserStatus(orderId)) {
            //1.从订单客户关联表中查询出订单的客户id列表
            List<OrderCustomer> orderCustomerList = orderCustomerDao.select(new OrderCustomer() {{
                setOrderId(orderId);
            }});
            //2.根据客户id列表,查询客户详情
            for (OrderCustomer orderCustomer : orderCustomerList) {
                Example example = new Example(Address.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("customerId", orderCustomer.getCustomerId());
                criteria.andEqualTo("isDel", "0");
                Customer customer = customerDao.selectOneByExample(example);
                addressList.add(customer);
            }
        }
        return addressList;
    }

    @Override
    public PageResult searchCustomerList(Condition condition) {
        return null;
    }
}
