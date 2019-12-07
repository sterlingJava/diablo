package com.ylzy56.diablo.domain;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "money_order")
@Data
public class MoneyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "money_order_no")
    private String moneyOrderNo;

    private String receiver;

    @Column(name = "receiver_account")
    private String receiverAccount;

    @Column(name = "pay_bank")
    private String payBank;

    @Column(name = "pay_money")
    private Long payMoney;

    @Column(name = "pay_matter")
    private String payMatter;

    private String payee;

    @Column(name = "pay_account")
    private String payAccount;

    @Column(name = "pay_date")
    private Date payDate;

    @Column(name = "account_time")
    private Date accountTime;

    private String status;

    private String isdel;

}