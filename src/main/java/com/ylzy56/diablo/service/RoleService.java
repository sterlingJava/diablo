package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Role;
import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface RoleService {
    void save(Role role);

    void delete(String roleId);

    void update(Role role);

    List<Role> findAll();

    Role findById(String roleId);

    void addPermissionToRole(String roleId, String permissionId);

    void deletePermissionFromRole(String roleId, String permissionId);

    List<Role> findRolesByUserId(String userId);

    List<Role> findOtherRoles(String userId);

    PageResult searchPage(Condition condition, String enterpriseId);

    boolean checkRoleStatus(String roleId);

}
