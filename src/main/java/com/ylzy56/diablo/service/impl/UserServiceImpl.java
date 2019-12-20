package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.*;
import com.ylzy56.diablo.domain.*;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.PermissionService;
import com.ylzy56.diablo.service.RoleService;
import com.ylzy56.diablo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.*;

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
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel","0");
        return userDao.selectByExample(example);
    }

    /**
     * 查询用户详情
     *
     * @param userId
     * @return
     */
    @Override
    public UserInfo findById(String userId) {
        //1.根据用户id查询用户信息
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        criteria.andEqualTo("isDel","0");
        UserInfo userInfo = userDao.selectOneByExample(example);
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
        return userInfo;
    }

    /**
     * 保存用户信息
     *
     * @param userInfo
     * @return
     */
    @Override
    public void save(UserInfo userInfo) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userInfo.getPassword();
        userInfo.setPassword(encoder.encode(rawPassword));
        userInfo.setCreateTime(new Date());
        userInfo.setIsDel("0");
        userDao.insertSelective(userInfo);
    }

    /**
     * 删除用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public void delete(String userId) {
        //1.删除用户角色关联表信息
        UserRoleDao.delete(new UserRole() {{
            setUserId(userId);
        }});
        //2.查询需要删除的用户
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        criteria.andEqualTo("isDel","0");
        UserInfo userInfo = userDao.selectOneByExample(example);
        if (!ObjectUtils.isEmpty(userInfo)) {
            userInfo.setIsDel("1");
            //2.删除用户信息
            userDao.updateByPrimaryKeySelective(userInfo);
        }
    }

    /**
     * 更新用户信息
     *
     * @param userInfo
     * @return
     */
    @Override
    public void update(UserInfo userInfo) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userInfo.getPassword();
        userInfo.setPassword(encoder.encode(rawPassword));
        //添加修改时间
        userInfo.setLastModifyTime(new Date());
        userDao.updateByPrimaryKeySelective(userInfo);

    }

    /**
     * 用户添加角色
     *
     * @param userId
     * @param roleId
     * @return
     */
    @Override
    public void addRoleToUser(String userId, String roleId) {
        //在用户角色关联表插入一条记录
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        UserRoleDao.insertSelective(userRole);

    }

    /**
     * 删除用户的角色
     *
     * @param userId
     * @param roleId
     * @return
     */
    @Override
    public void deleteRoleFromUser(String userId, String roleId) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        UserRoleDao.delete(userRole);
    }

    @Override
    public PageResult searchPage(Condition condition, String enterpriseId) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmpty(condition.getKeyword())) {
            criteria.orLike("username", "%" + condition.getKeyword() + "%");
            criteria.orLike("mobile", "%" + condition.getKeyword() + "%");
        }
        if (!StringUtil.isEmpty(condition.getStatus())){
            criteria.andEqualTo("status",condition.getStatus());
        }
        Example.Criteria exampleCriteria = example.createCriteria();
        exampleCriteria.andEqualTo("isDel","0");
        exampleCriteria.andEqualTo("enterpriseId",enterpriseId);
        example.and(exampleCriteria);
        Page<UserInfo> page = (Page<UserInfo>) userDao.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<UserInfo> searchUserInfo(Condition condition) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmpty(condition.getKeyword())) {
            criteria.orLike("username", "%" + condition.getKeyword() + "%");
            criteria.orLike("mobile", "%" + condition.getKeyword() + "%");
        }
        if (!StringUtil.isEmpty(condition.getStatus())){
            criteria.andEqualTo("status",condition.getStatus());
        }
        criteria.andEqualTo("isDel",0);
        return userDao.selectByExample(example);
    }

    @Override
    public UserInfo findByMobile(String username) {
        //1.根据手机号查询用户信息
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        criteria.andEqualTo("isDel","0");
        UserInfo userInfo = userDao.selectOneByExample(example);
        /*//2.根据用户id查询用包含的角色列表
        if (userInfo != null) {
            List<Role> roleList = roleService.findRolesByUserId(userInfo.getUserId());
            //3.遍历角色列表,根据角色id查询出包含的权限信息
            for (Role role : roleList) {
                List<Permission> permissionList = permissionService.findPermissionsByRoleId(role.getRoleId());
                role.setPermissions(permissionList);
            }
            userInfo.setRoles(roleList);
        }*/
        return userInfo;
    }

    @Override
    public UserInfo findByName(String username) {
        //1.根据手机号查询用户信息
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        criteria.andEqualTo("isDel","0");
        UserInfo userInfo = userDao.selectOneByExample(example);
        //2.根据用户id查询用包含的角色列表
        if (userInfo != null) {
            List<Role> roleList = roleService.findRolesByUserId(userInfo.getUserId());
            //3.遍历角色列表,根据角色id查询出包含的权限信息
            for (Role role : roleList) {
                List<Permission> permissionList = permissionService.findPermissionsByRoleId(role.getRoleId());
                role.setPermissions(permissionList);
            }
            userInfo.setRoles(roleList);
        }
        return userInfo;
    }

    @Override
    public Set<String> getPermissionSetByMobile(String username) {
        Set<String> set = new HashSet<>();
        //1.根据手机号查询用户信息
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        criteria.andEqualTo("isDel","0");
        UserInfo userInfo = userDao.selectOneByExample(example);
        //2.根据用户id查询用包含的角色列表
        if (userInfo != null) {
            List<Role> roleList = roleService.findRolesByUserId(userInfo.getUserId());
            if (!ObjectUtils.isEmpty(roleList)) {
                //3.遍历角色列表,根据角色id查询出包含的权限信息
                for (Role role : roleList) {
                    List<Permission> permissionList = permissionService.findPermissionsByRoleId(role.getRoleId());
                    if (!ObjectUtils.isEmpty(permissionList)) {
                        //set.addAll(permissionList);
                        for (Permission permission : permissionList) {
                            if (!ObjectUtils.isEmpty(permission)){
                                if (!ObjectUtils.isEmpty(permission.getUrl())) {
                                    set.add(permission.getUrl());
                                }
                            }
                        }
                    }
                }
            }
        }
        return set;
    }

    /**
     * 根据用户id查询用户状态
     * @param userId
     * @return 正常为true
     */
    @Override
    public boolean checkUserStatus(String userId) {
        //1.根据用户id查询用户信息
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        //criteria.andEqualTo("status","0");
        criteria.andEqualTo("isDel","0");
        UserInfo userInfo = userDao.selectOneByExample(example);
        if (ObjectUtils.isEmpty(userInfo)){
            return false;
        }else {
            return true;
        }
    }
}
