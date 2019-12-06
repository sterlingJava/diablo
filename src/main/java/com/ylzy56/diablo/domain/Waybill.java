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

}