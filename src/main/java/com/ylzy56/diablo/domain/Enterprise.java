package com.ylzy56.diablo.domain;

import com.ylzy56.diablo.domain.entity.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Data
public class Enterprise {
    /**
     * 企业id
     */
    @Id
    @KeySql(genId = UUIdGenId.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select uuid()")
    @Column(name = "enterprise_id")
    private String enterpriseId;

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
     * 备注:审核依据
     */
    private String notes;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

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
     * 审核人
     */
    private String reviewer;

    /**
     * 审核通过时间
     */
    @Column(name = "review_time")
    private Date reviewTime;

    /**
     * 审批状态(0:未审核,1:审核通过,2:审核未通过)
     */
    private String status;

    /**
     * 是否删除(0:未删除,1:删除)
     */
    @Column(name = "is_del")
    private String isDel;

}