package com.ylzy56.diablo.domain;

import javax.persistence.*;

@Table(name = "waybill_address")
public class WaybillAddress {
    @Id
    @Column(name = "waybill_id")
    private String waybillId;

    @Id
    @Column(name = "address_id")
    private Integer addressId;

    /**
     * @return waybill_id
     */
    public String getWaybillId() {
        return waybillId;
    }

    /**
     * @param waybillId
     */
    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId;
    }

    /**
     * @return address_id
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * @param addressId
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
}