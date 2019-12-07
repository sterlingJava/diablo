package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Role;
import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface RoleService {
    void save(Role role);

    void delete(int roleId);

    void update(Role role);

    List<Role> findAll();

    Role findById(int roleId);

    void addPermissionToRole(int roleId, int permissionId);

    void deletePermissionFromRole(int roleId, int permissionId);

    List<Role> findRolesByUserId(int userId);

    List<Role> findOtherRoles(int userId);

    PageResult findPage(int pageNum, int pageSize);

    PageResult searchPage(Condition condition, int pageNum, int pageSize);

    List<Role> searchRole(Condition condition);
}
