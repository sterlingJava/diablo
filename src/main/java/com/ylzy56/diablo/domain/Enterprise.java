package com.ylzy56.diablo.domain;

import javax.persistence.*;

public class Enterprise {
    /**
     * 企业id
     */
    @Id
    @Column(name = "enterprise_id")
    @GeneratedValue(generator = "JDBC")
    private Integer enterpriseId;

    /**
     * 企业名称
     */
    private String name;

    /**
     * 企业类型
     */
    private String type;

    /**
     * 营业执照号
     */
    @Column(name = "license_number")
    private String licenseNumber;

    /**
     * 营业执照附件
     */
    @Column(name = "license_pic")
    private String licensePic;

    /**
     * 固定资产
     */
    @Column(name = "fixed_assets")
    private String fixedAssets;

    /**
     * 注册资产
     */
    @Column(name = "registered_assets")
    private String registeredAssets;

    /**
     * 年营业额
     */
    @Column(name = "annual_turnover")
    private String annualTurnover;

    /**
     * 法人姓名
     */
    @Column(name = "corp_name")
    private String corpName;

    /**
     * 法人身份证号
     */
    @Column(name = "corp_idnum")
    private String corpIdnum;

    /**
     * 审批状态(0:未审核,1:审核通过,2:审核未通过)
     */
    private String status;

    /**
     * 备注:审核依据
     */
    private String notes;

    /**
     * 是否删除(0:未删除,1:删除)
     */
    @Column(name = "is_del")
    private String isDel;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 获取企业id
     *
     * @return enterprise_id - 企业id
     */
    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * 设置企业id
     *
     * @param enterpriseId 企业id
     */
    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * 获取企业名称
     *
     * @return name - 企业名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置企业名称
     *
     * @param name 企业名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取企业类型
     *
     * @return type - 企业类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置企业类型
     *
     * @param type 企业类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取营业执照号
     *
     * @return license_number - 营业执照号
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * 设置营业执照号
     *
     * @param licenseNumber 营业执照号
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * 获取营业执照附件
     *
     * @return license_pic - 营业执照附件
     */
    public String getLicensePic() {
        return licensePic;
    }

    /**
     * 设置营业执照附件
     *
     * @param licensePic 营业执照附件
     */
    public void setLicensePic(String licensePic) {
        this.licensePic = licensePic;
    }

    /**
     * 获取固定资产
     *
     * @return fixed_assets - 固定资产
     */
    public String getFixedAssets() {
        return fixedAssets;
    }

    /**
     * 设置固定资产
     *
     * @param fixedAssets 固定资产
     */
    public void setFixedAssets(String fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    /**
     * 获取注册资产
     *
     * @return registered_assets - 注册资产
     */
    public String getRegisteredAssets() {
        return registeredAssets;
    }

    /**
     * 设置注册资产
     *
     * @param registeredAssets 注册资产
     */
    public void setRegisteredAssets(String registeredAssets) {
        this.registeredAssets = registeredAssets;
    }

    /**
     * 获取年营业额
     *
     * @return annual_turnover - 年营业额
     */
    public String getAnnualTurnover() {
        return annualTurnover;
    }

    /**
     * 设置年营业额
     *
     * @param annualTurnover 年营业额
     */
    public void setAnnualTurnover(String annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    /**
     * 获取法人姓名
     *
     * @return corp_name - 法人姓名
     */
    public String getCorpName() {
        return corpName;
    }

    /**
     * 设置法人姓名
     *
     * @param corpName 法人姓名
     */
    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    /**
     * 获取法人身份证号
     *
     * @return corp_idnum - 法人身份证号
     */
    public String getCorpIdnum() {
        return corpIdnum;
    }

    /**
     * 设置法人身份证号
     *
     * @param corpIdnum 法人身份证号
     */
    public void setCorpIdnum(String corpIdnum) {
        this.corpIdnum = corpIdnum;
    }

    /**
     * 获取审批状态(0:未审核,1:审核通过,2:审核未通过)
     *
     * @return status - 审批状态(0:未审核,1:审核通过,2:审核未通过)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置审批状态(0:未审核,1:审核通过,2:审核未通过)
     *
     * @param status 审批状态(0:未审核,1:审核通过,2:审核未通过)
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取备注:审核依据
     *
     * @return notes - 备注:审核依据
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置备注:审核依据
     *
     * @param notes 备注:审核依据
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

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
}