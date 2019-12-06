package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.InvoiceMapper;
import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Invoice;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.InvoiceService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired(required = false)
    private InvoiceMapper invoiceMapper;


    @Override
    public List<Invoice> findAll() {
        return invoiceMapper.selectAll();
    }

    @Override
    public Invoice findById(int id) {
        return invoiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int save(Invoice invoice) {
        return invoiceMapper.insert(invoice);
    }

    @Override
    public int delete(int id) {
        Invoice invoice = findById(id);
        if (ObjectUtils.isEmpty(invoice)){
            throw new RuntimeException("不存在这条数据");
        }

        return 0;
    }

    @Override
    public int update(Invoice invoice) {
        return invoiceMapper.updateByPrimaryKey(invoice);
    }



    @Override
    public PageResult searchPage(String keyword, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
//        if (keyword != null && keyword.length() > 0) {
//            criteria.orLike("username", "%" + keyword + "%").orLike("mobile", "%" + keyword + "%");
//        }
        Page<Invoice> page = (Page<Invoice>) invoiceMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult searchNoPage(String keyword) {
        Example example = new Example(Invoice.class);
        Example.Criteria criteria = example.createCriteria();
//        if (keyword != null && keyword.length() > 0) {
//            criteria.orLike("username", "%" + keyword + "%").orLike("mobile", "%" + keyword + "%");
//        }
        Page<Invoice> page = (Page<Invoice>) invoiceMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
