package com.ylzy56.diablo.service.impl;

import com.ylzy56.diablo.dao.PermissionMapper;
import com.ylzy56.diablo.dao.RoleMapper;
import com.ylzy56.diablo.dao.RolePermissionMapper;
import com.ylzy56.diablo.domain.Permission;
import com.ylzy56.diablo.domain.Role;
import com.ylzy56.diablo.domain.RolePermission;
import com.ylzy56.diablo.service.PermissionService;
import com.ylzy56.diablo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired(required = false)
    private PermissionMapper permissionDao;

    @Autowired(required = false)
    private RolePermissionMapper rolePermissionDao;

    @Override
    public int save(Permission permission) {
        return permissionDao.insert(permission);
    }

    /**
     * 删除权限
     *
     * @param permissionId
     * @return
     */
    @Override
    public int delete(int permissionId) {
        try {
            //1.删除角色权限关联表记录
            RolePermission rolePermission = new RolePermission();
            rolePermission.setPermissionId(permissionId);
            rolePermissionDao.delete(rolePermission);
            //2.删除权限表记录
            return permissionDao.deleteByPrimaryKey(permissionId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 更新权限信息
     *
     * @param permission
     * @return
     */
    @Override
    public int update(Permission permission) {
        try {
            return permissionDao.updateByPrimaryKey(permission);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 查询所有权限列表
     *
     * @return
     */
    @Override
    public List<Permission> findAll() {
        List<Permission> permissionList = null;
        try {
            permissionList = permissionDao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permissionList;
    }

    /**
     * 查询权限详细信息
     *
     * @param permissionId
     * @return
     */
    @Override
    public Permission findById(int permissionId) {
        Permission permission = null;
        try {
            permission = permissionDao.selectByPrimaryKey(permissionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permission;
    }

    /**
     * 查找角色拥有的权限
     *
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> findPermissionsByRoleId(int roleId) {
        List<Permission> permissionList = new ArrayList<>();
        try {
            //1.根据角色id查询出包含的权限id列表
            List<RolePermission> rolePermissionList = rolePermissionDao.select(new RolePermission() {{
                setRoleId(roleId);
            }});
            //2.遍历权限id列表,查询权限详情
            for (RolePermission rolePermission : rolePermissionList) {
                Permission permission = permissionDao.selectByPrimaryKey(rolePermission.getPermissionId());
                permissionList.add(permission);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permissionList;
    }

    /**
     * 查询角色没有的权限
     *
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> findOtherPermissions(int roleId) {
        List<Permission> permissionList = null;
        List<Integer> permissionIdList = new ArrayList();
        try {
            List<RolePermission> rolePermissionList = rolePermissionDao.select(new RolePermission() {{
                setRoleId(roleId);
            }});
            for (RolePermission rolePermission : rolePermissionList) {
                permissionIdList.add(rolePermission.getPermissionId());
            }
            if (permissionIdList.size() == 0) {
                permissionList = permissionDao.selectAll();
            } else {
                Example example = new Example(Permission.class);
                example.createCriteria().andNotIn("permissionId", permissionIdList);
                permissionList = permissionDao.selectByExample(example);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permissionList;
    }
}
