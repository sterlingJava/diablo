package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.CarMapper;
import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Car;
import com.ylzy56.diablo.domain.Customer;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.CarService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired(required = false)
    private CarMapper carMapper;


    @Override
    public List<Car> findAll() {
        return carMapper.selectAll();
    }

    @Override
    public Car findById(String id) {
        //1.根据id查询地址信息
        Example example = new Example(Car.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("carId", id);
        criteria.andEqualTo("isDel", "0");
        return carMapper.selectOneByExample(example);
    }

    @Override
    public void save(Car car) {
        car.setSource("0");
        car.setIsDel("0");
        car.setCreateTime(new Date());
        carMapper.insertSelective(car);
    }

    @Override
    public void update(Car car) {
        car.setLastModifyTime(new Date());
        carMapper.updateByPrimaryKey(car);
    }

    @Override
    public PageResult searchPage(Condition condition, Integer pageNum, Integer pageSize) {
        if (ObjectUtils.isEmpty(pageNum)) {
            pageNum = 1;
        }
        if (ObjectUtils.isEmpty(pageSize)) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Car.class);
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
        example.and(exampleCriteria);
        Page<Car> page = (Page<Car>) carMapper.selectByExample(example);
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
        Page<Car> page = (Page<Car>) carMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }


    @Override
    public void delete(String id) {
        Car car = findById(id);
        if (ObjectUtils.isEmpty(car)) {
            throw new RuntimeException("不存在这条数据");
        }
        car.setIsDel("1");
        update(car);
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
//            carMapper.insert(address);
//        }


    }
}
