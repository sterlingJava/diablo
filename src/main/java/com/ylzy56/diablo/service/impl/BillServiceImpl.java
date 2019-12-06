package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.BillMapper;
import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Bill;
import com.ylzy56.diablo.domain.Invoice;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired(required = false)
    private BillMapper billMapper;


    @Override
    public List<Bill> findAll() {
        return billMapper.selectAll();
    }

    @Override
    public Bill findById(int id) {
        return billMapper.selectByPrimaryKey(id);
    }

    @Override
    public int save(Bill bill) {
        return billMapper.insert(bill);
    }

    @Override
    public int delete(int id) {
        Bill bill = findById(id);
        if (ObjectUtils.isEmpty(bill)){
            throw new RuntimeException("不存在这条数据");
        }

        return 0;
    }

    @Override
    public int update(Bill bill) {
        return billMapper.updateByPrimaryKey(bill);
    }



    @Override
    public PageResult searchPage(String keyword, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
//        if (keyword != null && keyword.length() > 0) {
//            criteria.orLike("username", "%" + keyword + "%").orLike("mobile", "%" + keyword + "%");
//        }
        Page<Bill> page = (Page<Bill>) billMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult searchNoPage(String keyword) {
        Example example = new Example(Invoice.class);
        Example.Criteria criteria = example.createCriteria();
//        if (keyword != null && keyword.length() > 0) {
//            criteria.orLike("username", "%" + keyword + "%").orLike("mobile", "%" + keyword + "%");
//        }
        Page<Bill> page = (Page<Bill>) billMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
