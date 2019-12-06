package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.InvoiceTitleMapper;
import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Invoice;
import com.ylzy56.diablo.domain.InvoiceTitle;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.InvoiceService;
import com.ylzy56.diablo.service.InvoiceTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class InvoiceTitleServiceImpl implements InvoiceTitleService {

    @Autowired(required = false)
    private InvoiceTitleMapper invoiceTitleMapper;


    @Override
    public List<InvoiceTitle> findAll() {
        return invoiceTitleMapper.selectAll();
    }

    @Override
    public InvoiceTitle findById(int id) {
        return invoiceTitleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int save(InvoiceTitle invoiceTitle) {
        return invoiceTitleMapper.insert(invoiceTitle);
    }

    @Override
    public int delete(int id) {
        InvoiceTitle invoiceTitle = findById(id);
        if (ObjectUtils.isEmpty(invoiceTitle)){
            throw new RuntimeException("不存在这条数据");
        }

        return 0;
    }

    @Override
    public int update(InvoiceTitle invoiceTitle) {
        return invoiceTitleMapper.updateByPrimaryKey(invoiceTitle);
    }



    @Override
    public PageResult searchPage(String keyword, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(InvoiceTitle.class);
        Example.Criteria criteria = example.createCriteria();
//        if (keyword != null && keyword.length() > 0) {
//            criteria.orLike("username", "%" + keyword + "%").orLike("mobile", "%" + keyword + "%");
//        }
        Page<InvoiceTitle> page = (Page<InvoiceTitle>) invoiceTitleMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult searchNoPage(String keyword) {
        Example example = new Example(InvoiceTitle.class);
        Example.Criteria criteria = example.createCriteria();
//        if (keyword != null && keyword.length() > 0) {
//            criteria.orLike("username", "%" + keyword + "%").orLike("mobile", "%" + keyword + "%");
//        }
        Page<InvoiceTitle> page = (Page<InvoiceTitle>) invoiceTitleMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
