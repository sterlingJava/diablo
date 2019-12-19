package com.ylzy56.diablo.domain;

import com.ylzy56.diablo.domain.entity.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "mailing_address")
public class MailingAddress {
    @Id
    @KeySql(genId = UUIdGenId.class)
    @Column(name = "mailing_address_id")
    private String mailingAddressId;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 联系人
     */
    @Column(name = "linkman_name")
    private String linkmanName;

    /**
     * 联系人电话
     */
    @Column(name = "linkman_mobile")
    private String linkmanMobile;

    /**
     * 固定电话
     */
    @Column(name = "fixed_line")
    private String fixedLine;

    /**
     * 所在地区
     */
    private String area;

    /**
     * 详细地址
     */
    @Column(name = "detailed_address")
    private String detailedAddress;

    /**
     * 是否默认
     */
    private String status;

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

    @Column(name = "enterprise_id")
    private String enterpriseId;
    }