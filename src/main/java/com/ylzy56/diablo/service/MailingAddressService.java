package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.MailingAddress;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface MailingAddressService {

    List<MailingAddress> findAll();
    MailingAddress findById(String id);
    void save(MailingAddress mailingAddress);
    void delete(String id);
    void update(MailingAddress mailingAddress);

    void lead(List<List<String>> list);

    PageResult searchNoPage(String keyword);

    PageResult searchPage(Condition condition, String enterpriseId);
}
