package com.ylzy56.diablo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class Car {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    /**
     * 车牌
     */
    @Column(name = "PLATE_NUMBER")
    private String plateNumber;

    /**
     * 车主姓名
     */
    @Column(name = "NAME")
    private String name;

    /**
     *
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 车辆属性
     */
    @Column(name = "CAR_PROPERTIES")
    private String carProperties;

    /**
     *车板类型
     */
    @Column(name = "PLATE_TYPE")
    private String plateType;

    /**
     *
     */
    @Column(name = "PLATE_PROPERTIES")
    private String plateProperties;

    /**
     *
     */
    @Column(name = "LOAD_MAX")
    private String loadMax;

    /**
     * 最大体积
     */
    @Column(name = "VOLUME_MAX")
    private String volumeMax;

    /**
     * 当前司机
     */
    @Column(name = "CURRENT_DRIVER")
    private String currentDriver;

    /**
     * 当前司机手机号码
     */
    @Column(name = "CURRENT_DRIVER_PHONE")
    private String currentDriverPhone;

    /**
     * 来源
     */
    @Column(name = "SOURCE")
    private String source;


    @Column(name = "ISDEL")
    private String isDel;

}