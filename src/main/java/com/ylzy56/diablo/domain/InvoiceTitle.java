package com.ylzy56.diablo.domain;

import com.ylzy56.diablo.domain.entity.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "invoice_title")
public class InvoiceTitle {
    @Id
    @KeySql(genId = UUIdGenId.class)
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

}