package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Car;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface CarService {

    List<Car> findAll();
    Car findById(String id);
    void save(Car car);
    void delete(String id);
    void update(Car car);

    void lead(List<List<String>> list);

    PageResult searchPage(Condition condition, Integer pageNum, Integer pageSize);

    PageResult searchNoPage(String keyword);

}
