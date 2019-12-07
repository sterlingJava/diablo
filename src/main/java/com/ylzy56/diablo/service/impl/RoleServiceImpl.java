package com.ylzy56.diablo.service.impl;

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
         roleDao.insert(role);
    }

    /**
     * 根据角色id删除角色
     *
     * @param roleId
     * @return
     */
    @Override
    public void delete(int roleId) {
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
            roleDao.updateByPrimaryKey(role);
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
        roleDao.updateByPrimaryKey(role);
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
    public Role findById(int roleId) {
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
    public void addPermissionToRole(int roleId, int permissionId) {
        //向角色权限关联表中插入一条记录
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(roleId);
        rolePermission.setPermissionId(permissionId);
        rolePermissionDao.insert(rolePermission);
    }

    /**
     * 从角色中删除权限
     *
     * @param roleId
     * @param permissionId
     * @return
     */
    @Override
    public void deletePermissionFromRole(int roleId, int permissionId) {
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
    public List<Role> findRolesByUserId(int userId) {
        List<Role> roleList = new ArrayList<>();
        if (userService.checkIsDel(userId)) {
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
    public List<Role> findOtherRoles(int userId) {
        List<Role> roleList = null;
        List<Integer> roleIdList = new ArrayList();
        if (userService.checkIsDel(userId)){
            try {
                List<UserRole> UserRoleList = UserRoleDao.select(new UserRole() {{
                    setUserId(userId);
                }});
                for (UserRole UserRole : UserRoleList) {
                    roleIdList.add(UserRole.getRoleId());
                }
                if (roleIdList.size() == 0) {
                    Example example = new Example(Role.class);
                    Example.Criteria criteria = example.createCriteria();
                    criteria.andEqualTo("isDel","0");
                    roleList = roleDao.selectByExample(example);
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
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public PageResult searchPage(Condition condition, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public List<Role> searchRole(Condition condition) {
        return null;
    }
}
