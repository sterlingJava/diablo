package com.ylzy56.diablo.domain;

import javax.persistence.*;

public class Car {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
     * 手机号码
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 车辆属性
     */
    @Column(name = "CAR_PROPERTIES")
    private String carProperties;

    /**
     * 车板类型
     */
    @Column(name = "PLATE_TYPE")
    private String plateType;

    /**
     * 车板长/宽/高
     */
    @Column(name = "PLATE_PROPERTIES")
    private String plateProperties;

    /**
     * 最大载重（吨）
     */
    @Column(name = "LOAD_MAX")
    private String loadMax;

    /**
     * 最大体积（方）
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

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取车牌
     *
     * @return PLATE_NUMBER - 车牌
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * 设置车牌
     *
     * @param plateNumber 车牌
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * 获取车主姓名
     *
     * @return NAME - 车主姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置车主姓名
     *
     * @param name 车主姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取手机号码
     *
     * @return PHONE - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取车辆属性
     *
     * @return CAR_PROPERTIES - 车辆属性
     */
    public String getCarProperties() {
        return carProperties;
    }

    /**
     * 设置车辆属性
     *
     * @param carProperties 车辆属性
     */
    public void setCarProperties(String carProperties) {
        this.carProperties = carProperties;
    }

    /**
     * 获取车板类型
     *
     * @return PLATE_TYPE - 车板类型
     */
    public String getPlateType() {
        return plateType;
    }

    /**
     * 设置车板类型
     *
     * @param plateType 车板类型
     */
    public void setPlateType(String plateType) {
        this.plateType = plateType;
    }

    /**
     * 获取车板长/宽/高
     *
     * @return PLATE_PROPERTIES - 车板长/宽/高
     */
    public String getPlateProperties() {
        return plateProperties;
    }

    /**
     * 设置车板长/宽/高
     *
     * @param plateProperties 车板长/宽/高
     */
    public void setPlateProperties(String plateProperties) {
        this.plateProperties = plateProperties;
    }

    /**
     * 获取最大载重（吨）
     *
     * @return LOAD_MAX - 最大载重（吨）
     */
    public String getLoadMax() {
        return loadMax;
    }

    /**
     * 设置最大载重（吨）
     *
     * @param loadMax 最大载重（吨）
     */
    public void setLoadMax(String loadMax) {
        this.loadMax = loadMax;
    }

    /**
     * 获取最大体积（方）
     *
     * @return VOLUME_MAX - 最大体积（方）
     */
    public String getVolumeMax() {
        return volumeMax;
    }

    /**
     * 设置最大体积（方）
     *
     * @param volumeMax 最大体积（方）
     */
    public void setVolumeMax(String volumeMax) {
        this.volumeMax = volumeMax;
    }

    /**
     * 获取当前司机
     *
     * @return CURRENT_DRIVER - 当前司机
     */
    public String getCurrentDriver() {
        return currentDriver;
    }

    /**
     * 设置当前司机
     *
     * @param currentDriver 当前司机
     */
    public void setCurrentDriver(String currentDriver) {
        this.currentDriver = currentDriver;
    }

    /**
     * 获取当前司机手机号码
     *
     * @return CURRENT_DRIVER_PHONE - 当前司机手机号码
     */
    public String getCurrentDriverPhone() {
        return currentDriverPhone;
    }

    /**
     * 设置当前司机手机号码
     *
     * @param currentDriverPhone 当前司机手机号码
     */
    public void setCurrentDriverPhone(String currentDriverPhone) {
        this.currentDriverPhone = currentDriverPhone;
    }

    /**
     * 获取来源
     *
     * @return SOURCE - 来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置来源
     *
     * @param source 来源
     */
    public void setSource(String source) {
        this.source = source;
    }
}