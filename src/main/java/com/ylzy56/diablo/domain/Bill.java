package com.ylzy56.diablo.domain;

import java.util.Date;
import javax.persistence.*;

public class Bill {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CREATEDBY")
    private String createdby;

    @Column(name = "CREATEDTIME")
    private Date createdtime;

    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    @Column(name = "WAYBILL_ID")
    private String waybillId;

    /**
     * 收款方
     */
    @Column(name = "PAYEE")
    private Long payee;

    /**
     * 收款账户
     */
    @Column(name = "ACCOUNT_PAYEE")
    private String accountPayee;

    @Column(name = "BANK")
    private String bank;

    /**
     * 应付总额
     */
    @Column(name = "PAYROLL")
    private Long payroll;

    @Column(name = "PAYMENT_TYPE")
    private String paymentType;

    /**
     * 支付渠道
     */
    @Column(name = "PAY_CHANNEL")
    private String payChannel;

    /**
     * 汇款单号
     */
    @Column(name = "REMITTANCE_NO")
    private String remittanceNo;

    /**
     * 付款人
     */
    @Column(name = "PAYER")
    private String payer;

    /**
     * 付款日期
     */
    @Column(name = "PAY_TIME")
    private Date payTime;

    /**
     * 付款状态
     */
    @Column(name = "PAY_STATUS")
    private String payStatus;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "IS_DEL")
    private String isDel;

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
     * @return WAYBILL_ID
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
     * 获取收款方
     *
     * @return PAYEE - 收款方
     */
    public Long getPayee() {
        return payee;
    }

    /**
     * 设置收款方
     *
     * @param payee 收款方
     */
    public void setPayee(Long payee) {
        this.payee = payee;
    }

    /**
     * 获取收款账户
     *
     * @return ACCOUNT_PAYEE - 收款账户
     */
    public String getAccountPayee() {
        return accountPayee;
    }

    /**
     * 设置收款账户
     *
     * @param accountPayee 收款账户
     */
    public void setAccountPayee(String accountPayee) {
        this.accountPayee = accountPayee;
    }

    /**
     * @return BANK
     */
    public String getBank() {
        return bank;
    }

    /**
     * @param bank
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * 获取应付总额
     *
     * @return PAYROLL - 应付总额
     */
    public Long getPayroll() {
        return payroll;
    }

    /**
     * 设置应付总额
     *
     * @param payroll 应付总额
     */
    public void setPayroll(Long payroll) {
        this.payroll = payroll;
    }

    /**
     * @return PAYMENT_TYPE
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 获取支付渠道
     *
     * @return PAY_CHANNEL - 支付渠道
     */
    public String getPayChannel() {
        return payChannel;
    }

    /**
     * 设置支付渠道
     *
     * @param payChannel 支付渠道
     */
    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    /**
     * 获取汇款单号
     *
     * @return REMITTANCE_NO - 汇款单号
     */
    public String getRemittanceNo() {
        return remittanceNo;
    }

    /**
     * 设置汇款单号
     *
     * @param remittanceNo 汇款单号
     */
    public void setRemittanceNo(String remittanceNo) {
        this.remittanceNo = remittanceNo;
    }

    /**
     * 获取付款人
     *
     * @return PAYER - 付款人
     */
    public String getPayer() {
        return payer;
    }

    /**
     * 设置付款人
     *
     * @param payer 付款人
     */
    public void setPayer(String payer) {
        this.payer = payer;
    }

    /**
     * 获取付款日期
     *
     * @return PAY_TIME - 付款日期
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置付款日期
     *
     * @param payTime 付款日期
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取付款状态
     *
     * @return PAY_STATUS - 付款状态
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * 设置付款状态
     *
     * @param payStatus 付款状态
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * @return STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return IS_DEL
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * @param isDel
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
}