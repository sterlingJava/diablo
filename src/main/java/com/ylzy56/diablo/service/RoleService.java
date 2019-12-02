package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Role;

import java.util.List;

public interface RoleService {
    int save(Role role);

    int delete(int roleId);

    int update(Role role);

    List<Role> findAll();

    Role findById(int roleId);

    int addPermissionToRole(int roleId, int permissionId);

    int deletePermissionFromRole(int roleId, int permissionId);

    List<Role> findRolesByUserId(int userId);

    List<Role> findOtherRoles(int userId);
}
