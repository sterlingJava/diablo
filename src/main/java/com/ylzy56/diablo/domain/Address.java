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
     * ��˾����
     */
    @Column(name = "ENTERPRISE_NAME")
    private String enterpriseName;

    /**
     * ��ϵ��
     */
    @Column(name = "LINKMAN")
    private String linkman;

    /**
     * ��ϵ�绰
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * ��ַ����
     */
    @Column(name = "ADDRESS_TYPE")
    private String addressType;

    /**
     * ���ڵ���
     */
    @Column(name = "AREA")
    private String area;

    /**
     * ��ϸ��ַ
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
     * ��ȡ��˾����
     *
     * @return ENTERPRISE_NAME - ��˾����
     */
    public String getEnterpriseName() {
        return enterpriseName;
    }

    /**
     * ���ù�˾����
     *
     * @param enterpriseName ��˾����
     */
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    /**
     * ��ȡ��ϵ��
     *
     * @return LINKMAN - ��ϵ��
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * ������ϵ��
     *
     * @param linkman ��ϵ��
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    /**
     * ��ȡ��ϵ�绰
     *
     * @return PHONE - ��ϵ�绰
     */
    public String getPhone() {
        return phone;
    }

    /**
     * ������ϵ�绰
     *
     * @param phone ��ϵ�绰
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * ��ȡ��ַ����
     *
     * @return ADDRESS_TYPE - ��ַ����
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * ���õ�ַ����
     *
     * @param addressType ��ַ����
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    /**
     * ��ȡ���ڵ���
     *
     * @return AREA - ���ڵ���
     */
    public String getArea() {
        return area;
    }

    /**
     * �������ڵ���
     *
     * @param area ���ڵ���
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * ��ȡ��ϸ��ַ
     *
     * @return DETAILED_ADDRESS - ��ϸ��ַ
     */
    public String getDetailedAddress() {
        return detailedAddress;
    }

    /**
     * ������ϸ��ַ
     *
     * @param detailedAddress ��ϸ��ַ
     */
    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }
}