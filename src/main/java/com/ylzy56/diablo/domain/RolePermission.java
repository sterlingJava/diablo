package com.ylzy56.diablo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "role_permission")
public class RolePermission {
    @Id
    @Column(name = "permission_id")
    private String permissionId;

    @Id
    @Column(name = "role_id")
    private String roleId;

}