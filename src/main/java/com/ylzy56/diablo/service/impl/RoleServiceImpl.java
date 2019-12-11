package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.RoleMapper;
import com.ylzy56.diablo.dao.RolePermissionMapper;
import com.ylzy56.diablo.dao.UserRoleMapper;
import com.ylzy56.diablo.domain.*;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.PermissionService;
import com.ylzy56.diablo.service.RoleService;
import com.ylzy56.diablo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private UserService userService;

    /**
     * 添加角色
     * @param role
     * @return
     */
    @Override
    public void save(Role role) {
        role.setCreateTime(new Date());
        role.setIsDel("0");
        roleDao.insertSelective(role);
    }

    /**
     * 根据角色id删除角色
     *
     * @param roleId
     * @return
     */
    @Override
    public void delete(String roleId) {
        //1.根据角色id删除用户角色关联表中记录
        UserRoleDao.delete(new UserRole() {{
            setRoleId(roleId);
        }});
        //2.根据角色id删除角色权限关联表中记录
        rolePermissionDao.delete(new RolePermission() {{
            setRoleId(roleId);
        }});
        //2.查询需要删除的角色
        Example example = new Example(Role.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", roleId);
        criteria.andEqualTo("isDel", "0");
        Role role = roleDao.selectOneByExample(example);
        if (!ObjectUtils.isEmpty(role)) {
            role.setIsDel("1");
            //2.删除角色信息
            roleDao.updateByPrimaryKeySelective(role);
        }
    }

    /**
     * 根据角色id更新角色
     *
     * @param role
     * @return
     */
    @Override
    public void update(Role role) {
        role.setLastModifyTime(new Date());
        roleDao.updateByPrimaryKeySelective(role);
    }

    /**
     * 查询所有角色信息
     *
     * @return
     */
    @Override
    public List<Role> findAll() {
        Example example = new Example(Role.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel","0");
        return roleDao.selectByExample(example);
    }

    /**
     * 根据角色id查询角色详情
     *
     * @param roleId
     * @return
     */
    @Override
    public Role findById(String roleId) {
        //1.根据角色id从角色表中查询到对应角色信息
        Example example = new Example(Role.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", roleId);
        criteria.andEqualTo("isDel", "0");
        Role role = roleDao.selectOneByExample(example);
        //2.根据角色id查询此角色的包含的权限信息并存入角色中
        List<Permission> permissionList = permissionService.findPermissionsByRoleId(roleId);
        if (!ObjectUtils.isEmpty(role)) {
            role.setPermissions(permissionList);
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
    public void addPermissionToRole(String roleId, String permissionId) {
        //向角色权限关联表中插入一条记录
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(roleId);
        rolePermission.setPermissionId(permissionId);
        rolePermissionDao.insertSelective(rolePermission);
    }

    /**
     * 从角色中删除权限
     *
     * @param roleId
     * @param permissionId
     * @return
     */
    @Override
    public void deletePermissionFromRole(String roleId, String permissionId) {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(roleId);
        rolePermission.setPermissionId(permissionId);
        rolePermissionDao.delete(rolePermission);
    }

    /**
     * 查询一个用户包含的角色信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<Role> findRolesByUserId(String userId) {
        List<Role> roleList = new ArrayList<>();
        if (userService.checkUserStatus(userId)) {
            //1.从用户角色关联表中查询出用户的角色id列表
            List<UserRole> UserRoleList = UserRoleDao.select(new UserRole() {{
                setUserId(userId);
            }});
            //2.根据角色id列表,查询角色详情
            for (UserRole userRole : UserRoleList) {
                Example example = new Example(Role.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("roleId", userRole.getRoleId());
                criteria.andEqualTo("isDel", "0");
                Role role = roleDao.selectOneByExample(example);
                roleList.add(role);
            }
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
    public List<Role> findOtherRoles(String userId) {
        List<Role> roleList = null;
        if (userService.checkUserStatus(userId)){
            try {
                List<String> roleIdList = new ArrayList();
                List<UserRole> UserRoleList = UserRoleDao.select(new UserRole() {{
                    setUserId(userId);
                }});
                for (UserRole UserRole : UserRoleList) {
                    roleIdList.add(UserRole.getRoleId());
                }
                if (roleIdList.size() == 0) {
                    roleList = findAll();
                } else {
                    Example example = new Example(Role.class);
                    Example.Criteria criteria = example.createCriteria();
                    criteria.andNotIn("roleId", roleIdList);
                    criteria.andEqualTo("isDel","0");
                    roleList = roleDao.selectByExample(example);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return roleList;
    }

    @Override
    public PageResult searchPage(Condition condition, Integer pageNum, Integer pageSize) {
        if (ObjectUtils.isEmpty(pageNum)){
            pageNum=1;
        }
        if (ObjectUtils.isEmpty(pageSize)){
            pageSize=10;
        }
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Role.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmpty(condition.getKeyword())) {
            criteria.orLike("roleName", "%" + condition.getKeyword() + "%");
            criteria.orLike("roleDesc", "%" + condition.getKeyword() + "%");
        }
        if (!StringUtil.isEmpty(condition.getStatus())){
            criteria.andEqualTo("status",condition.getStatus());
        }
        Example.Criteria exampleCriteria = example.createCriteria();
        exampleCriteria.andEqualTo("isDel","0");
        example.and(exampleCriteria);
        Page<Role> page = (Page<Role>) roleDao.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 根据id检查角色是否存在
     * @param roleId
     * @return
     *      true 存在
     *      false 不存在
     */
    @Override
    public boolean checkRoleStatus(String roleId) {
        Example example = new Example(Role.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", roleId);
        criteria.andEqualTo("isDel", "0");
        Role role = roleDao.selectOneByExample(example);
        if (ObjectUtils.isEmpty(role)){
            return false;
        }else {
            return true;
        }
    }
}
