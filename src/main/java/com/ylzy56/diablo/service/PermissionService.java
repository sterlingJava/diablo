package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Permission;

import java.util.List;

public interface PermissionService {
    int save(Permission permission);
    int delete(int permissionId);
    int update(Permission permission);
    List<Permission> findAll();
    Permission findById(int permissionId);
    List<Permission> findPermissionsByRoleId(int roleId);
    List<Permission> findOtherPermissions(int roleId);
}
