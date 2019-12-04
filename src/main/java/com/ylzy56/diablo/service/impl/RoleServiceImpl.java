package com.ylzy56.diablo.service.impl;

import com.ylzy56.diablo.dao.RoleMapper;
import com.ylzy56.diablo.dao.RolePermissionMapper;
import com.ylzy56.diablo.dao.UserRoleMapper;
import com.ylzy56.diablo.domain.Permission;
import com.ylzy56.diablo.domain.Role;
import com.ylzy56.diablo.domain.RolePermission;
import com.ylzy56.diablo.domain.UserRole;
import com.ylzy56.diablo.service.PermissionService;
import com.ylzy56.diablo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired(required = false)
    private RoleMapper roleDao;

    @Autowired(required = false)
    private RolePermissionMapper rolePermissionDao;

    @Autowired
    private UserRoleMapper UserRoleDao;

    @Autowired
    private PermissionService permissionService;

    /**
     * 添加角色
     * @param role
     * @return
     */
    @Override
    public int save(Role role) {
        return roleDao.insert(role);
    }

    /**
     * 根据角色id删除角色
     *
     * @param roleId
     * @return
     */
    @Override
    public int delete(int roleId) {
        try {
            //1.根据角色id删除用户角色关联表中记录
            UserRoleDao.delete(new UserRole() {{
                setRoleId(roleId);
            }});
            //2.根据角色id删除角色权限关联表中记录
            rolePermissionDao.delete(new RolePermission() {{
                setRoleId(roleId);
            }});
            //3.根据角色id删除角色表中记录
            return roleDao.deleteByPrimaryKey(roleId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 根据角色id更新角色
     *
     * @param role
     * @return
     */
    @Override
    public int update(Role role) {
        try {
            return roleDao.updateByPrimaryKey(role);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 查询所有角色信息
     *
     * @return
     */
    @Override
    public List<Role> findAll() {
        List<Role> roleList = null;
        try {
            roleList = roleDao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roleList;
    }

    /**
     * 根据角色id查询角色详情
     *
     * @param roleId
     * @return
     */
    @Override
    public Role findById(int roleId) {
        Role role = null;
        try {
            //1.根据角色id从角色表中查询到对应角色信息
            role = roleDao.selectByPrimaryKey(roleId);
            //2.根据角色id查询此角色的包含的权限信息并存入角色中
            List<Permission> permissionList = permissionService.findPermissionsByRoleId(roleId);
            role.setPermissions(permissionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

    /**
     * 给角色添加权限
     *
     * @param roleId
     * @param permissionId
     * @return
     */
    @Override
    public int addPermissionToRole(int roleId, int permissionId) {
        try {
            //向角色权限关联表中插入一条记录
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            return rolePermissionDao.insert(rolePermission);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 从角色中删除权限
     *
     * @param roleId
     * @param permissionId
     * @return
     */
    @Override
    public int deletePermissionFromRole(int roleId, int permissionId) {
        try {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            return rolePermissionDao.delete(rolePermission);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 查询一个用户包含的角色信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<Role> findRolesByUserId(int userId) {
        List<Role> roleList = new ArrayList<>();
        try {
            //1.从用户角色关联表中查询出用户的角色id列表
            List<UserRole> UserRoleList = UserRoleDao.select(new UserRole() {{
                setUserId(userId);
            }});
            //2.根据角色id列表,查询角色详情
            for (UserRole UserRole : UserRoleList) {
                Role role = roleDao.selectByPrimaryKey(UserRole.getRoleId());
                roleList.add(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roleList;
    }

    /**
     * 查询用户不具有的角色列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<Role> findOtherRoles(int userId) {
        List<Role> roleList = null;
        List<Integer> roleIdList = new ArrayList();
        try {
            List<UserRole> UserRoleList = UserRoleDao.select(new UserRole() {{
                setUserId(userId);
            }});
            for (UserRole UserRole : UserRoleList) {
                roleIdList.add(UserRole.getRoleId());
            }
            if (roleIdList.size() == 0) {
                roleList = roleDao.selectAll();
            } else {
                Example example = new Example(Role.class);
                example.createCriteria().andNotIn("roleId", roleIdList);
                roleList = roleDao.selectByExample(example);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roleList;
    }
}
