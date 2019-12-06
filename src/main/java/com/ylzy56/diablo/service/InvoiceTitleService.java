package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Invoice;
import com.ylzy56.diablo.domain.InvoiceTitle;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface InvoiceTitleService {

    List<InvoiceTitle> findAll();
    InvoiceTitle findById(int id);
    int save(InvoiceTitle invoice);
    int delete(int id);
    int update(InvoiceTitle invoice);

//    void lead(List<List<String>> list);

    PageResult searchPage(String keyword, int pageNum, int pageSize);

    PageResult searchNoPage(String keyword);

}
