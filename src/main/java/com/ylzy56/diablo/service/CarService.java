package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Car;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface CarService {

    List<Car> findAll();
    Car findById(int id);
    int save(Car car);
    int delete(int id);
    int update(Car car);

    void lead(List<List<String>> list);

    PageResult searchPage(String keyword, int pageNum, int pageSize);

}
