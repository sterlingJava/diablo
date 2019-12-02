package com.ylzy56.diablo.domain;

import java.util.Date;
import javax.persistence.*;

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "CREATED_BY")
    private Integer createdBy;

    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    @Column(name = "LAST_MODIFIED_BY")
    private Integer lastModifiedBy;

    /**
     * 公司名称
     */
    @Column(name = "ENTERPRISE_NAME")
    private String enterpriseName;

    /**
     * 联系人
     */
    @Column(name = "LINKMAN")
    private String linkman;

    /**
     * 联系电话
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 地址类型
     */
    @Column(name = "ADDRESS_TYPE")
    private String addressType;

    /**
     * 所在地区
     */
    @Column(name = "AREA")
    private String area;

    /**
     * 详细地址
     */
    @Column(name = "DETAILED_ADDRESS")
    private String detailedAddress;

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
     * @return CREATED_DATE
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return CREATED_BY
     */
    public Integer getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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
     * @return LAST_MODIFIED_BY
     */
    public Integer getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * @param lastModifiedBy
     */
    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     * 获取公司名称
     *
     * @return ENTERPRISE_NAME - 公司名称
     */
    public String getEnterpriseName() {
        return enterpriseName;
    }

    /**
     * 设置公司名称
     *
     * @param enterpriseName 公司名称
     */
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    /**
     * 获取联系人
     *
     * @return LINKMAN - 联系人
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * 设置联系人
     *
     * @param linkman 联系人
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    /**
     * 获取联系电话
     *
     * @return PHONE - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取地址类型
     *
     * @return ADDRESS_TYPE - 地址类型
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * 设置地址类型
     *
     * @param addressType 地址类型
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    /**
     * 获取所在地区
     *
     * @return AREA - 所在地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置所在地区
     *
     * @param area 所在地区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取详细地址
     *
     * @return DETAILED_ADDRESS - 详细地址
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
}