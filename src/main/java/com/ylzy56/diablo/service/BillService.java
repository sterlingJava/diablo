package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Bill;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface BillService {

    List<Bill> findAll();
    Bill findById(int id);
    int save(Bill bill);
    int delete(int id);
    int update(Bill bill);


    PageResult searchPage(String keyword, int pageNum, int pageSize);

    PageResult searchNoPage(String keyword);

}
