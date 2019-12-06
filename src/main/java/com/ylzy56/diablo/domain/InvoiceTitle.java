package com.ylzy56.diablo.domain;

import javax.persistence.*;

@Table(name = "invoice_title")
public class InvoiceTitle {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司名称
     */
    @Column(name = "ENTERPRISE_NAME")
    private String enterpriseName;

    /**
     * 纳税人识别号
     */
    @Column(name = "TAXPAYER_REGISTRATION_NUM")
    private String taxpayerRegistrationNum;

    /**
     * 开户银行
     */
    @Column(name = "BANK_NAME")
    private String bankName;

    /**
     * 银行账号
     */
    @Column(name = "BANK_NUM")
    private String bankNum;

    @Column(name = "PHONE")
    private String phone;

    /**
     * 注册地址
     */
    @Column(name = "REGISTRANT_ADDRESS")
    private String registrantAddress;

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
     * 获取公司名称
     *
     * @return ENTERPRISE_NAME - 公司名称
     */
    public String getEnterpriseName() {
        return enterpriseName;
    }

    /**
     * 设置公司名称
     *
     * @param enterpriseName 公司名称
     */
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    /**
     * 获取纳税人识别号
     *
     * @return TAXPAYER_REGISTRATION_NUM - 纳税人识别号
     */
    public String getTaxpayerRegistrationNum() {
        return taxpayerRegistrationNum;
    }

    /**
     * 设置纳税人识别号
     *
     * @param taxpayerRegistrationNum 纳税人识别号
     */
    public void setTaxpayerRegistrationNum(String taxpayerRegistrationNum) {
        this.taxpayerRegistrationNum = taxpayerRegistrationNum;
    }

    /**
     * 获取开户银行
     *
     * @return BANK_NAME - 开户银行
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置开户银行
     *
     * @param bankName 开户银行
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取银行账号
     *
     * @return BANK_NUM - 银行账号
     */
    public String getBankNum() {
        return bankNum;
    }

    /**
     * 设置银行账号
     *
     * @param bankNum 银行账号
     */
    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    /**
     * @return PHONE
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取注册地址
     *
     * @return REGISTRANT_ADDRESS - 注册地址
     */
    public String getRegistrantAddress() {
        return registrantAddress;
    }

    /**
     * 设置注册地址
     *
     * @param registrantAddress 注册地址
     */
    public void setRegistrantAddress(String registrantAddress) {
        this.registrantAddress = registrantAddress;
    }
}