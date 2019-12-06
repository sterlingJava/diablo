package com.ylzy56.diablo.domain;


import lombok.Data;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
public class Waybill {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "CREATEDBY")
    private String createdby;

    @Column(name = "CREATEDTIME")
    private Date createdtime;

    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name = "TOTAL_FREIGHT")
    private String totalFreight;

    @Column(name = "TOTAL_DISTANCE")
    private String totalDistance;

    @Column(name = "TOTAL_WEIFGT")
    private String totalWeifgt;

    @Column(name = "TOTAL_VOLUME")
    private String totalVolume;

    @Column(name = "PICK_UP_TIME")
    private Date pickUpTime;

    @Column(name = "ARRIVAL_TIME")
    private Date arrivalTime;

    /**
     * 货物
     */
    @Column(name = "CARGO")
    private String cargo;

    @Column(name = "SCHEDULE_METHOD")
    private String scheduleMethod;

    @Column(name = "CAR")
    private String car;

    @Column(name = "DRIVER_PHONE")
    private String driverPhone;

    /**
     * 保险名称
     */
    @Column(name = "INSURANCE_NAME")
    private String insuranceName;

    /**
     * 保险费
     */
    @Column(name = "INSURANCE_MONEY")
    private Long insuranceMoney;

    /**
     * 运费预付
     */
    @Column(name = "FREIGHT_FIRST")
    private Long freightFirst;

    /**
     * 运费结付
     */
    @Column(name = "FREIGHT_FINAL")
    private Long freightFinal;

    /**
     * 油卡结付比例
     */
    @Column(name = "OIL_CARD")
    private Long oilCard;

    /**
     * 服务费
     */
    @Column(name = "SERVICE_FEE")
    private Long serviceFee;

    @Transient
    private List<Address> addressIds;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return CREATEDBY
     */
    public String getCreatedby() {
        return createdby;
    }

    /**
     * @param createdby
     */
    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    /**
     * @return CREATEDTIME
     */
    public Date getCreatedtime() {
        return createdtime;
    }

    /**
     * @param createdtime
     */
    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    /**
     * @return LAST_MODIFIED_DATE
     */
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * @param lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * @return LAST_MODIFIED_BY
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * @param lastModifiedBy
     */
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     * @return ORDER_ID
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
     * @return TOTAL_FREIGHT
     */
    public String getTotalFreight() {
        return totalFreight;
    }

    /**
     * @param totalFreight
     */
    public void setTotalFreight(String totalFreight) {
        this.totalFreight = totalFreight;
    }

    /**
     * @return TOTAL_DISTANCE
     */
    public String getTotalDistance() {
        return totalDistance;
    }

    /**
     * @param totalDistance
     */
    public void setTotalDistance(String totalDistance) {
        this.totalDistance = totalDistance;
    }

    /**
     * @return TOTAL_WEIFGT
     */
    public String getTotalWeifgt() {
        return totalWeifgt;
    }

    /**
     * @param totalWeifgt
     */
    public void setTotalWeifgt(String totalWeifgt) {
        this.totalWeifgt = totalWeifgt;
    }

    /**
     * @return TOTAL_VOLUME
     */
    public String getTotalVolume() {
        return totalVolume;
    }

    /**
     * @param totalVolume
     */
    public void setTotalVolume(String totalVolume) {
        this.totalVolume = totalVolume;
    }

    /**
     * @return PICK_UP_TIME
     */
    public Date getPickUpTime() {
        return pickUpTime;
    }

    /**
     * @param pickUpTime
     */
    public void setPickUpTime(Date pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    /**
     * @return ARRIVAL_TIME
     */
    public Date getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @param arrivalTime
     */
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * 获取货物
     *
     * @return CARGO - 货物
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * 设置货物
     *
     * @param cargo 货物
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return SCHEDULE_METHOD
     */
    public String getScheduleMethod() {
        return scheduleMethod;
    }

    /**
     * @param scheduleMethod
     */
    public void setScheduleMethod(String scheduleMethod) {
        this.scheduleMethod = scheduleMethod;
    }

    /**
     * @return CAR
     */
    public String getCar() {
        return car;
    }

    /**
     * @param car
     */
    public void setCar(String car) {
        this.car = car;
    }

    /**
     * @return DRIVER_PHONE
     */
    public String getDriverPhone() {
        return driverPhone;
    }

    /**
     * @param driverPhone
     */
    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    /**
     * 获取保险名称
     *
     * @return INSURANCE_NAME - 保险名称
     */
    public String getInsuranceName() {
        return insuranceName;
    }

    /**
     * 设置保险名称
     *
     * @param insuranceName 保险名称
     */
    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    /**
     * 获取保险费
     *
     * @return INSURANCE_MONEY - 保险费
     */
    public Long getInsuranceMoney() {
        return insuranceMoney;
    }

    /**
     * 设置保险费
     *
     * @param insuranceMoney 保险费
     */
    public void setInsuranceMoney(Long insuranceMoney) {
        this.insuranceMoney = insuranceMoney;
    }

    /**
     * 获取运费预付
     *
     * @return FREIGHT_FIRST - 运费预付
     */
    public Long getFreightFirst() {
        return freightFirst;
    }

    /**
     * 设置运费预付
     *
     * @param freightFirst 运费预付
     */
    public void setFreightFirst(Long freightFirst) {
        this.freightFirst = freightFirst;
    }

    /**
     * 获取运费结付
     *
     * @return FREIGHT_FINAL - 运费结付
     */
    public Long getFreightFinal() {
        return freightFinal;
    }

    /**
     * 设置运费结付
     *
     * @param freightFinal 运费结付
     */
    public void setFreightFinal(Long freightFinal) {
        this.freightFinal = freightFinal;
    }

    /**
     * 获取油卡结付比例
     *
     * @return OIL_CARD - 油卡结付比例
     */
    public Long getOilCard() {
        return oilCard;
    }

    /**
     * 设置油卡结付比例
     *
     * @param oilCard 油卡结付比例
     */
    public void setOilCard(Long oilCard) {
        this.oilCard = oilCard;
    }

    /**
     * 获取服务费
     *
     * @return SERVICE_FEE - 服务费
     */
    public Long getServiceFee() {
        return serviceFee;
    }

    /**
     * 设置服务费
     *
     * @param serviceFee 服务费
     */
    public void setServiceFee(Long serviceFee) {
        this.serviceFee = serviceFee;
    }
}