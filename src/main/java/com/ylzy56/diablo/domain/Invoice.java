package com.ylzy56.diablo.domain;

import com.ylzy56.diablo.domain.entity.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Data
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

    private MailingAddress mailingAddress;
}