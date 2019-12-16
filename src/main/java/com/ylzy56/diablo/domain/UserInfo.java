package com.ylzy56.diablo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ylzy56.diablo.domain.entity.UUIdGenId;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
@Table(name = "e_user")
public class UserInfo implements UserDetails{
    /**
     * 企业用户id
     */
    @Id
    @Column(name = "user_id")
    @KeySql(genId = UUIdGenId.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select uuid()")
    private String userId;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String username;

    /**
     * 企业id
     */
    @Column(name = "enterprise_id")
    private String enterpriseId;

    /**
     * 账号级别(0:母账号)
     */
    private String level;

    /**
     * 所属部门
     */
    @Column(name = "department_name")
    private String departmentName;

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

    @Override
    //@Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<Role> roles = this.getRoles();
        if (!ObjectUtils.isEmpty(roles)) {
            for (Role role : roles) {
                auths.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
        }
        return auths;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}