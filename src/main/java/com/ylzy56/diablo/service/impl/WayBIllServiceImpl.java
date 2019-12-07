package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.WaybillMapper;
import com.ylzy56.diablo.domain.Waybill;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.WayBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class WayBIllServiceImpl implements WayBillService {

    @Autowired(required = false)
    private WaybillMapper waybillMapper;


    @Override
    public List<Waybill> findAll() {
        return waybillMapper.selectAll();
    }

    @Override
    public Waybill findById(int id) {
        return waybillMapper.selectByPrimaryKey(id);
    }

    @Override
    public int save(Waybill waybill) {


        return waybillMapper.insert(waybill);
    }

    @Override
    public int delete(int id) {
        Waybill waybill = findById(id);
        if (ObjectUtils.isEmpty(waybill)){
            throw new RuntimeException("不存在这条数据");
        }

        return 0;
    }

    @Override
    public int update(Waybill waybill) {
        return waybillMapper.updateByPrimaryKey(waybill);
    }

    @Override
    public PageResult searchPage(String keyword, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Waybill.class);
        Example.Criteria criteria = example.createCriteria();
//        if (keyword != null && keyword.length() > 0) {
//            criteria.orLike("username", "%" + keyword + "%").orLike("mobile", "%" + keyword + "%");
//        }
        Page<Waybill> page = (Page<Waybill>)waybillMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult searchNoPage(String keyword) {
//        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Waybill.class);
        Example.Criteria criteria = example.createCriteria();
//        if (keyword != null && keyword.length() > 0) {
//            criteria.orLike("username", "%" + keyword + "%").orLike("mobile", "%" + keyword + "%");
//        }
        Page<Waybill> page = (Page<Waybill>)waybillMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

}
