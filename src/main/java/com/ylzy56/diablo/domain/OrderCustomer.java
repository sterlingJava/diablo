package com.ylzy56.diablo.domain;

import javax.persistence.*;

@Table(name = "order_customer")
public class OrderCustomer {
    @Id
    @Column(name = "order_id")
    private String orderId;

    @Id
    @Column(name = "customer_id")
    private String customerId;

    /**
     * @return order_id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return customer_id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}