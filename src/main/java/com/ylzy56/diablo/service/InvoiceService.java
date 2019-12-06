package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Invoice;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface InvoiceService {

    List<Invoice> findAll();
    Invoice findById(int id);
    int save(Invoice invoice);
    int delete(int id);
    int update(Invoice invoice);

//    void lead(List<List<String>> list);

    PageResult searchPage(String keyword, int pageNum, int pageSize);

    PageResult searchNoPage(String keyword);

}
