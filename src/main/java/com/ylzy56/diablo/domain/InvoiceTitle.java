package com.ylzy56.diablo.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "invoice_title")
public class InvoiceTitle {
    @Id
    @Column(name = "invoice_title_id")
    private String invoiceTitleId;

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
     * 状态(0:正在使用,1没在使用)
     */
    private String status;

    /**
     * 企业id
     */
    @Column(name = "enterprise_id")
    private String enterpriseId;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * @return invoice_title_id
     */
    public String getInvoiceTitleId() {
        return invoiceTitleId;
    }

    /**
     * @param invoiceTitleId
     */
    public void setInvoiceTitleId(String invoiceTitleId) {
        this.invoiceTitleId = invoiceTitleId;
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
     * 获取状态(0:正在使用,1没在使用)
     *
     * @return status - 状态(0:正在使用,1没在使用)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态(0:正在使用,1没在使用)
     *
     * @param status 状态(0:正在使用,1没在使用)
     */
    public void setStatus(String status) {
        this.status = status;
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
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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