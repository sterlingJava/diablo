package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionService {
    void save(Permission permission);
    void delete(String permissionId);
    void update(Permission permission);
    List<Permission> findAll();
    Permission findById(String permissionId);
    List<Permission> findPermissionsByRoleId(String roleId);
    List<Permission> findOtherPermissions(String roleId);

    List<Permission> findAllByGrade();
}
