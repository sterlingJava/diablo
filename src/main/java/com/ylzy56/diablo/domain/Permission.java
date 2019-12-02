package com.ylzy56.diablo.domain;

import javax.persistence.*;
import java.util.List;

public class Permission {
    @Id
    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "permission_name")
    private String permissionName;

    private String url;

    @Column(name = "permission_level")
    private String permissionLevel;

    @Column(name = "parent_permission_id")
    private Integer parentPermissionId;

    private Integer type;

    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     * @return permission_id
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * @return permission_name
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * @param permissionName
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return permission_level
     */
    public String getPermissionLevel() {
        return permissionLevel;
    }

    /**
     * @param permissionLevel
     */
    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    /**
     * @return parent_permission_id
     */
    public Integer getParentPermissionId() {
        return parentPermissionId;
    }

    /**
     * @param parentPermissionId
     */
    public void setParentPermissionId(Integer parentPermissionId) {
        this.parentPermissionId = parentPermissionId;
    }

    /**
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }
}