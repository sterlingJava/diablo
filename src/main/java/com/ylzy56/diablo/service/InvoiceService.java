package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Invoice;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface InvoiceService {

    Invoice findById(String id);
    void save(Invoice invoice);
    void delete(String id);
    void update(Invoice invoice);

    PageResult searchPage(Condition condition, String enterpriseId);


}
