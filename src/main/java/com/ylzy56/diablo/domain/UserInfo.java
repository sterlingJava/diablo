package com.ylzy56.diablo.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
@Table(name = "e_user")
public class UserInfo {
    /**
     * 企业用户id
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 企业id
     */
    @Column(name = "enterprise_id")
    private Integer enterpriseId;

    /**
     * 账号级别(0:母账号)
     */
    private String level;

    /**
     * 使用状态(0:正常,1:异常)
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
     * 异常原因备注
     */
    private String notes;

    /**
     * 是否删除(0:未删除,1:删除)
     */
    @Column(name = "is_del")
    private String isDel;

    private List<Role> roles;
}