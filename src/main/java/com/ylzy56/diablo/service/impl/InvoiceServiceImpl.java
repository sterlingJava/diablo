package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.InvoiceMapper;
import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Customer;
import com.ylzy56.diablo.domain.Invoice;
import com.ylzy56.diablo.domain.Order;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.InvoiceService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired(required = false)
    private InvoiceMapper invoiceMapper;


    @Override
    public Invoice findById(String id) {
        /*//1.根据id查询企业信息
        Example example = new Example(Invoice.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("invoiceId",id);
        criteria.andEqualTo("isDel","0");
        Invoice invoice = invoiceMapper.selectOneByExample(example);
        if (!ObjectUtils.isEmpty(invoice)) {
            Customer customer = customerService.findById(order.getCustomerId());
            if (!ObjectUtils.isEmpty(customer)) {
                invoice.setCustomer(customer);
            }
        }

        return order;*/
        return null;
    }

    @Override
    public void save(Invoice invoice) {
         invoiceMapper.insert(invoice);
    }

    @Override
    public void delete(String id) {
        Invoice invoice = findById(id);
        if (ObjectUtils.isEmpty(invoice)){
            throw new RuntimeException("不存在这条数据");
        }

    }

    @Override
    public void update(Invoice invoice) {
         invoiceMapper.updateByPrimaryKey(invoice);
    }

    @Override
    public PageResult searchPage(Condition condition, String enterpriseId) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        Example example = new Example(Invoice.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmpty(condition.getKeyword())) {
            criteria.orLike("companyName", "%" + condition.getKeyword() + "%");
        }
        if (!StringUtil.isEmpty(condition.getStatus())){
            criteria.andEqualTo("status",condition.getStatus());
        }
        Example.Criteria exampleCriteria = example.createCriteria();
        exampleCriteria.andEqualTo("isDel","0");
        exampleCriteria.andEqualTo("enterpriseId",enterpriseId);
        example.and(exampleCriteria);
        Page<Invoice> page = (Page<Invoice>) invoiceMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
