package com.ylzy56.diablo.domain.entity;

import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Customer;
import com.ylzy56.diablo.domain.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderVo {
    private Order order;
    private List<Address> addressList;
    private Customer customer;
}
