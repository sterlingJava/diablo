package com.ylzy56.diablo.domain;

import com.ylzy56.diablo.domain.entity.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Data
@Entity
public class Address {
    @Id
    @KeySql(genId = UUIdGenId.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private String addressId;

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
     * 企业id
     */
    @Column(name = "enterprise_id")
    private String enterpriseId;

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
     * 修改人
     */
    @Column(name = "last_modifier")
    private String lastModifier;

    /**
     * 修改时间
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

    }