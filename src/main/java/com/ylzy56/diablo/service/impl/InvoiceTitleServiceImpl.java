package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.InvoiceTitleMapper;
import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Car;
import com.ylzy56.diablo.domain.Invoice;
import com.ylzy56.diablo.domain.InvoiceTitle;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.InvoiceService;
import com.ylzy56.diablo.service.InvoiceTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class InvoiceTitleServiceImpl implements InvoiceTitleService {

    @Autowired(required = false)
    private InvoiceTitleMapper invoiceTitleMapper;

    @Override
    public void save(InvoiceTitle invoiceTitle) {
        Example example = new Example(InvoiceTitle.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", "0");
        criteria.andEqualTo("isDel", "0");
        criteria.andEqualTo("enterpriseId", invoiceTitle.getEnterpriseId());
        invoiceTitleMapper.updateByExampleSelective(new InvoiceTitle(){{setStatus("1");}},example);
        invoiceTitle.setStatus("0");
        invoiceTitle.setIsDel("0");
        invoiceTitle.setCreateTime(new Date());
        invoiceTitleMapper.insertSelective(invoiceTitle);
    }

    @Override
    public InvoiceTitle findBeUse(String status,String enterpriseId) {
        //1.根据id查询地址信息
        Example example = new Example(InvoiceTitle.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", status);
        criteria.andEqualTo("isDel", "0");
        criteria.andEqualTo("enterpriseId", enterpriseId);
        return invoiceTitleMapper.selectOneByExample(example);
    }
}
