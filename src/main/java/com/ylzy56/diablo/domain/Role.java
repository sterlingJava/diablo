package com.ylzy56.diablo.domain;

import javax.persistence.*;
import java.util.List;

public class Role {
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_desc")
    private String roleDesc;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "parent_role_id")
    private Integer parentRoleId;

    private List<UserInfo> usersList;

    private List<Permission> permissions;

    public List<UserInfo> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<UserInfo> usersList) {
        this.usersList = usersList;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return role_desc
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * @param roleDesc
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    /**
     * @return role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return parent_role_id
     */
    public Integer getParentRoleId() {
        return parentRoleId;
    }

    /**
     * @param parentRoleId
     */
    public void setParentRoleId(Integer parentRoleId) {
        this.parentRoleId = parentRoleId;
    }
}