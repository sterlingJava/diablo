package com.ylzy56.diablo.domain;

import java.util.Date;
import javax.persistence.*;

public class Invoice {
    @Id
    @Column(name = "invoice_id")
    private String invoiceId;

    /**
     * 发票编码
     */
    @Column(name = "invoice_code")
    private String invoiceCode;

    /**
     * 含税金额
     */
    @Column(name = "tax_amount")
    private String taxAmount;

    /**
     * 税率
     */
    @Column(name = "tax_rate")
    private String taxRate;

    /**
     * 发票抬头
     */
    @Column(name = "invoice_title")
    private String invoiceTitle;

    /**
     * 纳税人识别号
     */
    @Column(name = "tax_num")
    private String taxNum;

    /**
     * 开户银行
     */
    @Column(name = "deposit_bank")
    private String depositBank;

    /**
     * 银行账户
     */
    @Column(name = "bank_account")
    private String bankAccount;

    /**
     * 固定电话
     */
    @Column(name = "fixed_line")
    private String fixedLine;

    /**
     * 注册地址
     */
    @Column(name = "register_address")
    private String registerAddress;

    /**
     * 开票公司
     */
    @Column(name = "invoice_company")
    private String invoiceCompany;

    /**
     * 状态
     */
    private String status;

    /**
     * 纸质发票金额
     */
    @Column(name = "paper_invoice_num")
    private String paperInvoiceNum;

    /**
     * 物流公司
     */
    private String logistics;

    /**
     * 物流单号
     */
    @Column(name = "logistics_num")
    private String logisticsNum;

    /**
     * 企业id
     */
    @Column(name = "enterprise_id")
    private String enterpriseId;

    /**
     * 申请人
     */
    private String applicant;

    /**
     * 申请时间
     */
    @Column(name = "apply_time")
    private Date applyTime;

    /**
     * 开具人
     */
    private String reviewer;

    /**
     * 开具时间
     */
    @Column(name = "review_time")
    private Date reviewTime;

    /**
     * 备注
     */
    private String notes;

    /**
     * 是否删除(0:未删除,1:删除)
     */
    @Column(name = "is_del")
    private String isDel;

    /**
     * @return invoice_id
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * @param invoiceId
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * 获取发票编码
     *
     * @return invoice_code - 发票编码
     */
    public String getInvoiceCode() {
        return invoiceCode;
    }

    /**
     * 设置发票编码
     *
     * @param invoiceCode 发票编码
     */
    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    /**
     * 获取含税金额
     *
     * @return tax_amount - 含税金额
     */
    public String getTaxAmount() {
        return taxAmount;
    }

    /**
     * 设置含税金额
     *
     * @param taxAmount 含税金额
     */
    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * 获取税率
     *
     * @return tax_rate - 税率
     */
    public String getTaxRate() {
        return taxRate;
    }

    /**
     * 设置税率
     *
     * @param taxRate 税率
     */
    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * 获取发票抬头
     *
     * @return invoice_title - 发票抬头
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * 设置发票抬头
     *
     * @param invoiceTitle 发票抬头
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    /**
     * 获取纳税人识别号
     *
     * @return tax_num - 纳税人识别号
     */
    public String getTaxNum() {
        return taxNum;
    }

    /**
     * 设置纳税人识别号
     *
     * @param taxNum 纳税人识别号
     */
    public void setTaxNum(String taxNum) {
        this.taxNum = taxNum;
    }

    /**
     * 获取开户银行
     *
     * @return deposit_bank - 开户银行
     */
    public String getDepositBank() {
        return depositBank;
    }

    /**
     * 设置开户银行
     *
     * @param depositBank 开户银行
     */
    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }

    /**
     * 获取银行账户
     *
     * @return bank_account - 银行账户
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 设置银行账户
     *
     * @param bankAccount 银行账户
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * 获取固定电话
     *
     * @return fixed_line - 固定电话
     */
    public String getFixedLine() {
        return fixedLine;
    }

    /**
     * 设置固定电话
     *
     * @param fixedLine 固定电话
     */
    public void setFixedLine(String fixedLine) {
        this.fixedLine = fixedLine;
    }

    /**
     * 获取注册地址
     *
     * @return register_address - 注册地址
     */
    public String getRegisterAddress() {
        return registerAddress;
    }

    /**
     * 设置注册地址
     *
     * @param registerAddress 注册地址
     */
    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    /**
     * 获取开票公司
     *
     * @return invoice_company - 开票公司
     */
    public String getInvoiceCompany() {
        return invoiceCompany;
    }

    /**
     * 设置开票公司
     *
     * @param invoiceCompany 开票公司
     */
    public void setInvoiceCompany(String invoiceCompany) {
        this.invoiceCompany = invoiceCompany;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取纸质发票金额
     *
     * @return paper_invoice_num - 纸质发票金额
     */
    public String getPaperInvoiceNum() {
        return paperInvoiceNum;
    }

    /**
     * 设置纸质发票金额
     *
     * @param paperInvoiceNum 纸质发票金额
     */
    public void setPaperInvoiceNum(String paperInvoiceNum) {
        this.paperInvoiceNum = paperInvoiceNum;
    }

    /**
     * 获取物流公司
     *
     * @return logistics - 物流公司
     */
    public String getLogistics() {
        return logistics;
    }

    /**
     * 设置物流公司
     *
     * @param logistics 物流公司
     */
    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    /**
     * 获取物流单号
     *
     * @return logistics_num - 物流单号
     */
    public String getLogisticsNum() {
        return logisticsNum;
    }

    /**
     * 设置物流单号
     *
     * @param logisticsNum 物流单号
     */
    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum;
    }

    /**
     * 获取企业id
     *
     * @return enterprise_id - 企业id
     */
    public String getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * 设置企业id
     *
     * @param enterpriseId 企业id
     */
    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * 获取申请人
     *
     * @return applicant - 申请人
     */
    public String getApplicant() {
        return applicant;
    }

    /**
     * 设置申请人
     *
     * @param applicant 申请人
     */
    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    /**
     * 获取申请时间
     *
     * @return apply_time - 申请时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 设置申请时间
     *
     * @param applyTime 申请时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取开具人
     *
     * @return reviewer - 开具人
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * 设置开具人
     *
     * @param reviewer 开具人
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    /**
     * 获取开具时间
     *
     * @return review_time - 开具时间
     */
    public Date getReviewTime() {
        return reviewTime;
    }

    /**
     * 设置开具时间
     *
     * @param reviewTime 开具时间
     */
    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    /**
     * 获取备注
     *
     * @return notes - 备注
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置备注
     *
     * @param notes 备注
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * 获取是否删除(0:未删除,1:删除)
     *
     * @return is_del - 是否删除(0:未删除,1:删除)
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * 设置是否删除(0:未删除,1:删除)
     *
     * @param isDel 是否删除(0:未删除,1:删除)
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
}