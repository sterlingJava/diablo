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
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

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
        return userDao.selectAll();
    }

    /**
     * 查询用户详情
     *
     * @param userId
     * @return
     */
    @Override
    public UserInfo findById(int userId) {

        //1.根据用户id查询用户信息
        UserInfo userInfo = userDao.selectByPrimaryKey(userId);
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
        userInfo.setStatus("0");
        userInfo.setIsDel("0");
        userDao.insert(userInfo);
    }

    /**
     * 删除用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public void delete(int userId) {
        //1.删除用户角色关联表信息
        UserRoleDao.delete(new UserRole() {{
            setUserId(userId);
        }});
        //2.删除用户信息
        userDao.deleteByPrimaryKey(userId);

    }

    /**
     * 更新用户信息
     *
     * @param userInfo
     * @return
     */
    @Override
    public void update(UserInfo userInfo) {

        userDao.updateByPrimaryKey(userInfo);

    }

    /**
     * 用户添加角色
     *
     * @param userId
     * @param roleId
     * @return
     */
    @Override
    public void addRoleToUser(int userId, int roleId) {

        //在用户角色关联表插入一条记录
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        UserRoleDao.insert(userRole);

    }

    /**
     * 删除用户的角色
     *
     * @param userId
     * @param roleId
     * @return
     */
    @Override
    public void deleteRoleFromUser(int userId, int roleId) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        UserRoleDao.delete(userRole);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<UserInfo> page = (Page<UserInfo>) userDao.selectAll();
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult searchPage(Condition condition, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
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
    public UserInfo findByMobile(String mobile) {
        return userDao.selectOne(new UserInfo(){{setMobile(mobile);}});
    }
}
