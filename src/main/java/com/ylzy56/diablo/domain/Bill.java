package com.ylzy56.diablo.domain;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
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

}