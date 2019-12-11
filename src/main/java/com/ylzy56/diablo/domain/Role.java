package com.ylzy56.diablo.domain;

import com.ylzy56.diablo.domain.entity.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
public class Role {
    @Id
    @Column(name = "role_id")
    @KeySql(genId = UUIdGenId.class)
    private String roleId;

    /**
     * 角色描述
     */
    @Column(name = "role_desc")
    private String roleDesc;

    /**
     * 角色姓名
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 父角色id
     */
    @Column(name = "parent_role_id")
    private Integer parentRoleId;

    /**
     * 企业id
     */
    @Column(name = "enterprise_id")
    private String enterpriseId;

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

    private List<UserInfo> userInfos;

    private List<Permission> permissions;

    }