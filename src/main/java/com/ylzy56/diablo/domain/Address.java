package com.ylzy56.diablo.domain;

import com.ylzy56.diablo.domain.entity.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "address")
@Entity
public class Address {
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    /**
     * 企业id
     */
    @Column(name = "enterprise_id")
    private String enterpriseId;

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
     * 手机
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * ��ַ����
     */
    @Column(name = "ADDRESS_TYPE")
    private String addressType;

    /**
     * 地区
     */
    @Column(name = "AREA")
    private String area;

    /**
     * 详细地址
     */
    @Column(name = "DETAILED_ADDRESS")
    private String detailedAddress;


    @Column(name = "SOURCE")
    private String source;

    @Column(name = "ISDEL")
    private String isDel;


}