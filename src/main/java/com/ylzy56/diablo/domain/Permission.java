package com.ylzy56.diablo.domain;

import java.util.Date;
import javax.persistence.*;

public class Permission {
    @Id
    @Column(name = "permission_id")
    private Integer permissionId;

    /**
     * 权限名称
     */
    @Column(name = "permission_name")
    private String permissionName;

    /**
     * 权限地址
     */
    private String url;

    /**
     * 权限登记
     */
    @Column(name = "permission_level")
    private String permissionLevel;

    /**
     * 父权限
     */
    @Column(name = "parent_permission_id")
    private Integer parentPermissionId;

    /**
     * 类型
     */
    private Integer type;

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
     * 获取权限名称
     *
     * @return permission_name - 权限名称
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 设置权限名称
     *
     * @param permissionName 权限名称
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * 获取权限地址
     *
     * @return url - 权限地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置权限地址
     *
     * @param url 权限地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取权限登记
     *
     * @return permission_level - 权限登记
     */
    public String getPermissionLevel() {
        return permissionLevel;
    }

    /**
     * 设置权限登记
     *
     * @param permissionLevel 权限登记
     */
    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    /**
     * 获取父权限
     *
     * @return parent_permission_id - 父权限
     */
    public Integer getParentPermissionId() {
        return parentPermissionId;
    }

    /**
     * 设置父权限
     *
     * @param parentPermissionId 父权限
     */
    public void setParentPermissionId(Integer parentPermissionId) {
        this.parentPermissionId = parentPermissionId;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改人
     *
     * @return last_modifier - 修改人
     */
    public String getLastModifier() {
        return lastModifier;
    }

    /**
     * 设置修改人
     *
     * @param lastModifier 修改人
     */
    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier;
    }

    /**
     * 获取修改时间
     *
     * @return last_modify_time - 修改时间
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param lastModifyTime 修改时间
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * 获取备注
     *
     * @return notes - 备注
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置备注
     *
     * @param notes 备注
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * 获取是否删除(0:未删除,1:删除)
     *
     * @return is_del - 是否删除(0:未删除,1:删除)
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * 设置是否删除(0:未删除,1:删除)
     *
     * @param isDel 是否删除(0:未删除,1:删除)
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
}