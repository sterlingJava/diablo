package com.ylzy56.diablo.domain;

import com.ylzy56.diablo.domain.entity.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Data
public class Customer {
    @Id
    @Column(name = "customer_id")
    @KeySql(genId = UUIdGenId.class)
    private String customerId;

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
     * 企业id
     */
    @Column(name = "enterprise_id")
    private String enterpriseId;


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

}