package com.ylzy56.diablo.domain;

import java.util.Date;
import javax.persistence.*;

public class Customer {
    @Id
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 客户简称
     */
    private String abbreviation;

    /**
     * 客户全称
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * 客户属性
     */
    private String attribute;

    /**
     * 所在地
     */
    private String address;

    /**
     * 详细地址
     */
    @Column(name = "detailed_address")
    private String detailedAddress;

    /**
     * 联系人姓名
     */
    @Column(name = "linkman_name")
    private String linkmanName;

    /**
     * 联系电话
     */
    @Column(name = "linkman_phone")
    private String linkmanPhone;

    /**
     * 状态(0,正常,1,异常)
     */
    private String status;

    /**
     * 来源(0,录入,1,导入)
     */
    private String source;

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
     * 最后修改人
     */
    @Column(name = "last_modifier")
    private String lastModifier;

    /**
     * 最后时间
     */
    @Column(name = "last_modify_time")
    private Date lastModifyTime;

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
     * @return customer_id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取客户简称
     *
     * @return abbreviation - 客户简称
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * 设置客户简称
     *
     * @param abbreviation 客户简称
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * 获取客户全称
     *
     * @return full_name - 客户全称
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 设置客户全称
     *
     * @param fullName 客户全称
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 获取客户属性
     *
     * @return attribute - 客户属性
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * 设置客户属性
     *
     * @param attribute 客户属性
     */
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    /**
     * 获取所在地
     *
     * @return address - 所在地
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置所在地
     *
     * @param address 所在地
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取详细地址
     *
     * @return detailed_address - 详细地址
     */
    public String getDetailedAddress() {
        return detailedAddress;
    }

    /**
     * 设置详细地址
     *
     * @param detailedAddress 详细地址
     */
    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    /**
     * 获取联系人姓名
     *
     * @return linkman_name - 联系人姓名
     */
    public String getLinkmanName() {
        return linkmanName;
    }

    /**
     * 设置联系人姓名
     *
     * @param linkmanName 联系人姓名
     */
    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    /**
     * 获取联系电话
     *
     * @return linkman_phone - 联系电话
     */
    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    /**
     * 设置联系电话
     *
     * @param linkmanPhone 联系电话
     */
    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }

    /**
     * 获取状态(0,正常,1,异常)
     *
     * @return status - 状态(0,正常,1,异常)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态(0,正常,1,异常)
     *
     * @param status 状态(0,正常,1,异常)
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取来源(0,录入,1,导入)
     *
     * @return source - 来源(0,录入,1,导入)
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置来源(0,录入,1,导入)
     *
     * @param source 来源(0,录入,1,导入)
     */
    public void setSource(String source) {
        this.source = source;
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
     * 获取最后修改人
     *
     * @return last_modifier - 最后修改人
     */
    public String getLastModifier() {
        return lastModifier;
    }

    /**
     * 设置最后修改人
     *
     * @param lastModifier 最后修改人
     */
    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier;
    }

    /**
     * 获取最后时间
     *
     * @return last_modify_time - 最后时间
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 设置最后时间
     *
     * @param lastModifyTime 最后时间
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
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