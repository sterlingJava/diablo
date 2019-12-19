package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Invoice;
import com.ylzy56.diablo.domain.InvoiceTitle;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface InvoiceTitleService {

    void save(InvoiceTitle invoiceTitle);
    InvoiceTitle findBeUse(String status,String enterpriseId);
}
