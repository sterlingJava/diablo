package com.ylzy56.diablo.domain;

import javax.persistence.*;

@Table(name = "order_address")
public class OrderAddress {
    /**
     * 订单id
     */
    @Id
    @Column(name = "order_id")
    private String orderId;

    /**
     * 地址id
     */
    @Id
    @Column(name = "address_id")
    private String addressId;

    /**
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取地址id
     *
     * @return address_id - 地址id
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * 设置地址id
     *
     * @param addressId 地址id
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
}