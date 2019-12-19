package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.MailingAddressMapper;
import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.MailingAddress;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.MailingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;

@Service
public class MailingAddressServiceImpl implements MailingAddressService {
    @Autowired(required = false)
    private MailingAddressMapper mailingAddressDao;


    @Override
    public List<MailingAddress> findAll() {
        return mailingAddressDao.selectAll();
    }

    @Override
    public MailingAddress findById(String id) {
        //1.根据id查询地址信息
        Example example = new Example(MailingAddress.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("mailingAddressId", id);
        criteria.andEqualTo("isDel", "0");
        return mailingAddressDao.selectOneByExample(example);
    }

    @Override
    public void save(MailingAddress MailingAddress) {
        MailingAddress.setIsDel("0");
        MailingAddress.setCreateTime(new Date());
        mailingAddressDao.insertSelective(MailingAddress);
    }

    @Override
    public void update(MailingAddress MailingAddress) {
        MailingAddress.setLastModifyTime(new Date());
        mailingAddressDao.updateByPrimaryKey(MailingAddress);
    }

    @Override
    public PageResult searchPage(Condition condition,String enterpriseId) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        Example example = new Example(MailingAddress.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmpty(condition.getKeyword())) {
            criteria.orLike("abbreviation", "%" + condition.getKeyword() + "%");
            criteria.orLike("full_name", "%" + condition.getKeyword() + "%");
        }
        if (!StringUtil.isEmpty(condition.getStatus())) {
            criteria.andEqualTo("status", condition.getStatus());
        }
        Example.Criteria exampleCriteria = example.createCriteria();
        exampleCriteria.andEqualTo("isDel", "0");
        exampleCriteria.andEqualTo("enterpriseId", enterpriseId);
        example.and(exampleCriteria);
        Page<MailingAddress> page = (Page<MailingAddress>) mailingAddressDao.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult searchNoPage(String keyword) {
        Example example = new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel", "0");
//        if (keyword != null && keyword.length() > 0) {
//            criteria.orLike("username", "%" + keyword + "%").orLike("mobile", "%" + keyword + "%");
//        }
        Page<MailingAddress> page = (Page<MailingAddress>) mailingAddressDao.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }


    @Override
    public void delete(String id) {
        MailingAddress MailingAddress = findById(id);
        if (ObjectUtils.isEmpty(MailingAddress)) {
            throw new RuntimeException("不存在这条数据");
        }
        MailingAddress.setIsDel("1");
        update(MailingAddress);
    }

    @Override
    public void lead(List<List<String>> list) {

//        for (int i = 0; i < list.size(); i++) {
//            List<String> lo = list.get(i);
//            int size = list.get(i).size();//长度
//
//            Address address = new Address();
//            address.setEnterpriseName(lo.get(1));
//            address.setLinkman(lo.get(2));
//            address.setPhone(lo.get(3));
//            address.setAddressType(lo.get(4));
//            address.setArea(lo.get(5));
//            address.setDetailedAddress(lo.get(6));
//            address.setCreated(lo.get(7));
//            mailingAddressDao.insert(address);
//        }


    }
}
