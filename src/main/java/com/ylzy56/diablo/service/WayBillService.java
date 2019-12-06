package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Waybill;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface WayBillService {

    List<Waybill> findAll();
    Waybill findById(int id);
    int save(Waybill waybill);
    int delete(int id);
    int update(Waybill waybill);


    PageResult searchPage(String keyword, int pageNum, int pageSize);
    PageResult searchNoPage(String keyword);

}
