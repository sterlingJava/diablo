package com.ylzy56.diablo.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "money_order")
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

    /**
     * @return id
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
     * @return money_order_no
     */
    public String getMoneyOrderNo() {
        return moneyOrderNo;
    }

    /**
     * @param moneyOrderNo
     */
    public void setMoneyOrderNo(String moneyOrderNo) {
        this.moneyOrderNo = moneyOrderNo;
    }

    /**
     * @return receiver
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * @param receiver
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * @return receiver_account
     */
    public String getReceiverAccount() {
        return receiverAccount;
    }

    /**
     * @param receiverAccount
     */
    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    /**
     * @return pay_bank
     */
    public String getPayBank() {
        return payBank;
    }

    /**
     * @param payBank
     */
    public void setPayBank(String payBank) {
        this.payBank = payBank;
    }

    /**
     * @return pay_money
     */
    public Long getPayMoney() {
        return payMoney;
    }

    /**
     * @param payMoney
     */
    public void setPayMoney(Long payMoney) {
        this.payMoney = payMoney;
    }

    /**
     * @return pay_matter
     */
    public String getPayMatter() {
        return payMatter;
    }

    /**
     * @param payMatter
     */
    public void setPayMatter(String payMatter) {
        this.payMatter = payMatter;
    }

    /**
     * @return payee
     */
    public String getPayee() {
        return payee;
    }

    /**
     * @param payee
     */
    public void setPayee(String payee) {
        this.payee = payee;
    }

    /**
     * @return pay_account
     */
    public String getPayAccount() {
        return payAccount;
    }

    /**
     * @param payAccount
     */
    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    /**
     * @return pay_date
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * @param payDate
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * @return account_time
     */
    public Date getAccountTime() {
        return accountTime;
    }

    /**
     * @param accountTime
     */
    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }

    /**
     * @return status
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
     * @return isdel
     */
    public String getIsdel() {
        return isdel;
    }

    /**
     * @param isdel
     */
    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }
}