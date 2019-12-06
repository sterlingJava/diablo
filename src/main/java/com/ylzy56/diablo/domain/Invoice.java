package com.ylzy56.diablo.domain;

import java.util.Date;
import javax.persistence.*;

public class Invoice {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CREATEDBY")
    private String createdby;

    @Column(name = "CREATEDTIME")
    private Date createdtime;

    /**
     * 发票编码
     */
    @Column(name = "CODE")
    private String code;

    /**
     * 含税金额
     */
    @Column(name = "TAX_AMOUNT")
    private Long taxAmount;

    @Column(name = "TAX_RATE")
    private Double taxRate;

    @Column(name = "INVOICE_TITLE")
    private String invoiceTitle;

    @Column(name = "ENTERPRISE")
    private String enterprise;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PAPER_INVOICE_NUMBER")
    private String paperInvoiceNumber;

    /**
     * 物流公司
     */
    @Column(name = "LOGISTICS_COMPANY")
    private String logisticsCompany;

    /**
     * 物流单号
     */
    @Column(name = "LOGISTICS_NO")
    private String logisticsNo;

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
     * 获取发票编码
     *
     * @return CODE - 发票编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置发票编码
     *
     * @param code 发票编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取含税金额
     *
     * @return TAX_AMOUNT - 含税金额
     */
    public Long getTaxAmount() {
        return taxAmount;
    }

    /**
     * 设置含税金额
     *
     * @param taxAmount 含税金额
     */
    public void setTaxAmount(Long taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * @return TAX_RATE
     */
    public Double getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate
     */
    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * @return INVOICE_TITLE
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * @param invoiceTitle
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    /**
     * @return ENTERPRISE
     */
    public String getEnterprise() {
        return enterprise;
    }

    /**
     * @param enterprise
     */
    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
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
     * @return PAPER_INVOICE_NUMBER
     */
    public String getPaperInvoiceNumber() {
        return paperInvoiceNumber;
    }

    /**
     * @param paperInvoiceNumber
     */
    public void setPaperInvoiceNumber(String paperInvoiceNumber) {
        this.paperInvoiceNumber = paperInvoiceNumber;
    }

    /**
     * 获取物流公司
     *
     * @return LOGISTICS_COMPANY - 物流公司
     */
    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    /**
     * 设置物流公司
     *
     * @param logisticsCompany 物流公司
     */
    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    /**
     * 获取物流单号
     *
     * @return LOGISTICS_NO - 物流单号
     */
    public String getLogisticsNo() {
        return logisticsNo;
    }

    /**
     * 设置物流单号
     *
     * @param logisticsNo 物流单号
     */
    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }
}