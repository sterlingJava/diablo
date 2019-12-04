package com.ylzy56.diablo.domain;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "address")
@Entity
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


    @Column(name = "CREATED")
    private String created;

    @Column(name = "ISDEL")
    private String isDel;


}