package com.ylzy56.diablo.domain;

import javax.persistence.*;

public class Car {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * ����
     */
    @Column(name = "PLATE_NUMBER")
    private String plateNumber;

    /**
     * ��������
     */
    @Column(name = "NAME")
    private String name;

    /**
     * �ֻ�����
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * ��������
     */
    @Column(name = "CAR_PROPERTIES")
    private String carProperties;

    /**
     * ��������
     */
    @Column(name = "PLATE_TYPE")
    private String plateType;

    /**
     * ���峤/��/��
     */
    @Column(name = "PLATE_PROPERTIES")
    private String plateProperties;

    /**
     * ������أ��֣�
     */
    @Column(name = "LOAD_MAX")
    private String loadMax;

    /**
     * ������������
     */
    @Column(name = "VOLUME_MAX")
    private String volumeMax;

    /**
     * ��ǰ˾��
     */
    @Column(name = "CURRENT_DRIVER")
    private String currentDriver;

    /**
     * ��ǰ˾���ֻ�����
     */
    @Column(name = "CURRENT_DRIVER_PHONE")
    private String currentDriverPhone;

    /**
     * ��Դ
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
     * ��ȡ����
     *
     * @return PLATE_NUMBER - ����
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * ���ó���
     *
     * @param plateNumber ����
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * ��ȡ��������
     *
     * @return NAME - ��������
     */
    public String getName() {
        return name;
    }

    /**
     * ���ó�������
     *
     * @param name ��������
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��ȡ�ֻ�����
     *
     * @return PHONE - �ֻ�����
     */
    public String getPhone() {
        return phone;
    }

    /**
     * �����ֻ�����
     *
     * @param phone �ֻ�����
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * ��ȡ��������
     *
     * @return CAR_PROPERTIES - ��������
     */
    public String getCarProperties() {
        return carProperties;
    }

    /**
     * ���ó�������
     *
     * @param carProperties ��������
     */
    public void setCarProperties(String carProperties) {
        this.carProperties = carProperties;
    }

    /**
     * ��ȡ��������
     *
     * @return PLATE_TYPE - ��������
     */
    public String getPlateType() {
        return plateType;
    }

    /**
     * ���ó�������
     *
     * @param plateType ��������
     */
    public void setPlateType(String plateType) {
        this.plateType = plateType;
    }

    /**
     * ��ȡ���峤/��/��
     *
     * @return PLATE_PROPERTIES - ���峤/��/��
     */
    public String getPlateProperties() {
        return plateProperties;
    }

    /**
     * ���ó��峤/��/��
     *
     * @param plateProperties ���峤/��/��
     */
    public void setPlateProperties(String plateProperties) {
        this.plateProperties = plateProperties;
    }

    /**
     * ��ȡ������أ��֣�
     *
     * @return LOAD_MAX - ������أ��֣�
     */
    public String getLoadMax() {
        return loadMax;
    }

    /**
     * ����������أ��֣�
     *
     * @param loadMax ������أ��֣�
     */
    public void setLoadMax(String loadMax) {
        this.loadMax = loadMax;
    }

    /**
     * ��ȡ������������
     *
     * @return VOLUME_MAX - ������������
     */
    public String getVolumeMax() {
        return volumeMax;
    }

    /**
     * ����������������
     *
     * @param volumeMax ������������
     */
    public void setVolumeMax(String volumeMax) {
        this.volumeMax = volumeMax;
    }

    /**
     * ��ȡ��ǰ˾��
     *
     * @return CURRENT_DRIVER - ��ǰ˾��
     */
    public String getCurrentDriver() {
        return currentDriver;
    }

    /**
     * ���õ�ǰ˾��
     *
     * @param currentDriver ��ǰ˾��
     */
    public void setCurrentDriver(String currentDriver) {
        this.currentDriver = currentDriver;
    }

    /**
     * ��ȡ��ǰ˾���ֻ�����
     *
     * @return CURRENT_DRIVER_PHONE - ��ǰ˾���ֻ�����
     */
    public String getCurrentDriverPhone() {
        return currentDriverPhone;
    }

    /**
     * ���õ�ǰ˾���ֻ�����
     *
     * @param currentDriverPhone ��ǰ˾���ֻ�����
     */
    public void setCurrentDriverPhone(String currentDriverPhone) {
        this.currentDriverPhone = currentDriverPhone;
    }

    /**
     * ��ȡ��Դ
     *
     * @return SOURCE - ��Դ
     */
    public String getSource() {
        return source;
    }

    /**
     * ������Դ
     *
     * @param source ��Դ
     */
    public void setSource(String source) {
        this.source = source;
    }
}