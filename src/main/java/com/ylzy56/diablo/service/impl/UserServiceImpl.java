package com.ylzy56.diablo.service.impl;

import com.ylzy56.diablo.dao.*;
import com.ylzy56.diablo.domain.*;
import com.ylzy56.diablo.service.PermissionService;
import com.ylzy56.diablo.service.RoleService;
import com.ylzy56.diablo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserInfoMapper userDao;

    @Autowired(required = false)
    private RoleMapper roleDao;

    @Autowired(required = false)
    private RoleService roleService;

    @Autowired(required = false)
    private UserRoleMapper UserRoleDao;

    @Autowired(required = false)
    private PermissionService permissionService;

    /**
     * 查询用户列表
     *
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> usersList = null;
        try {
            usersList = userDao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }

    /**
     * 查询用户详情
     *
     * @param userId
     * @return
     */
    @Override
    public UserInfo findById(int userId) {
        UserInfo userInfo = null;
        try {
            //1.根据用户id查询用户信息
            userInfo = userDao.selectByPrimaryKey(userId);
            //2.根据用户id查询用包含的角色列表
            List<Role> roleList = roleService.findRolesByUserId(userId);
            //3.遍历角色列表,根据角色id查询出包含的权限信息
            for (Role role : roleList) {
                List<Permission> permissionList = permissionService.findPermissionsByRoleId(role.getRoleId());
                role.setPermissions(permissionList);
            }
            if (userInfo != null) {
                userInfo.setRoles(roleList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    /**
     * 保存用户信息
     *
     * @param userInfo
     * @return
     */
    @Override
    public int save(UserInfo userInfo) {
        try {
            return userDao.insert(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 删除用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public int delete(int userId) {
        try {
            //1.删除用户角色关联表信息
            UserRoleDao.delete(new UserRole() {{
                setUserId(userId);
            }});
            //2.删除用户信息
            return userDao.deleteByPrimaryKey(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 更新用户信息
     *
     * @param userInfo
     * @return
     */
    @Override
    public int update(UserInfo userInfo) {
        try {
            return userDao.updateByPrimaryKey(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 用户添加角色
     *
     * @param userId
     * @param roleId
     * @return
     */
    @Override
    public int addRoleToUser(int userId, int roleId) {
        try {
            //在用户角色关联表插入一条记录
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            return UserRoleDao.insert(userRole);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 删除用户的角色
     *
     * @param userId
     * @param roleId
     * @return
     */
    @Override
    public int deleteRoleFromUser(int userId, int roleId) {
        try {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            return UserRoleDao.delete(userRole);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
