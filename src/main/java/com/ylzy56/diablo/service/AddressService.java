package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Role;
import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface AddressService {

    List<Address> findAll();
    Address findById(String id);
    void save(Address address);
    void delete(String id);
    void update(Address address);

    void lead(List<List<String>> list);

    List<Address> searchNoPage(String keyword);

    List<Address> findAddressByOrderId(String orderId);

    PageResult searchPage(Condition condition, String enterpriseId);
}
