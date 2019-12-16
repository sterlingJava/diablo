package com.ylzy56.diablo.service.impl;

import com.ylzy56.diablo.dao.PermissionMapper;
import com.ylzy56.diablo.dao.RoleMapper;
import com.ylzy56.diablo.dao.RolePermissionMapper;
import com.ylzy56.diablo.domain.*;
import com.ylzy56.diablo.service.PermissionService;
import com.ylzy56.diablo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired(required = false)
    private PermissionMapper permissionDao;

    @Autowired(required = false)
    private RolePermissionMapper rolePermissionDao;

    @Autowired
    private RoleService roleService;

    @Override
    public void save(Permission permission) {
        permission.setCreateTime(new Date());
        permission.setIsDel("0");
        permissionDao.insertSelective(permission);
    }

    /**
     * 删除权限
     *
     * @param permissionId
     * @return
     */
    @Override
    public void delete(String permissionId) {
        //1.删除角色权限关联表记录
        rolePermissionDao.delete(new RolePermission() {{
            setRoleId(permissionId);
        }});
        //2.查询需要删除的权限
        Example example = new Example(Permission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("permissionId", permissionId);
        criteria.andEqualTo("isDel", "0");
        Permission permission = permissionDao.selectOneByExample(example);
        if (!ObjectUtils.isEmpty(permission)) {
            permission.setIsDel("1");
            //2.删除权限信息
            permissionDao.updateByPrimaryKeySelective(permission);
        }
    }

    /**
     * 更新权限信息
     *
     * @param permission
     * @return
     */
    @Override
    public void update(Permission permission) {
        permission.setLastModifyTime(new Date());
        permissionDao.updateByPrimaryKeySelective(permission);
    }

    /**
     * 查询所有权限列表
     *
     * @return
     */
    @Override
    public List<Permission> findAll() {
        Example example = new Example(Permission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel","0");
        return permissionDao.selectByExample(example);

    }

    /**
     * 查询权限详细信息
     *
     * @param permissionId
     * @return
     */
    @Override
    public Permission findById(String permissionId) {
        Example example = new Example(Permission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("permissionId",permissionId);
        criteria.andEqualTo("isDel","0");
        return permissionDao.selectOneByExample(example);
    }

    /**
     * 查找角色拥有的权限
     *
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> findPermissionsByRoleId(String roleId) {
        List<Permission> permissionList = new ArrayList<>();
        try {
            if (roleService.checkRoleStatus(roleId)) {
                //1.根据角色id查询出包含的权限id列表
                List<RolePermission> rolePermissionList = rolePermissionDao.select(new RolePermission() {{
                    setRoleId(roleId);
                }});
                //2.遍历权限id列表,查询权限详情
                for (RolePermission rolePermission : rolePermissionList) {
                    Permission permission = findById(rolePermission.getPermissionId());
                    permissionList.add(permission);
                }
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
    public List<Permission> findOtherPermissions(String roleId) {
        List<Permission> permissionList = null;
        try {
            if (roleService.checkRoleStatus(roleId)) {
                List<String> permissionIdList = new ArrayList();
                List<RolePermission> rolePermissionList = rolePermissionDao.select(new RolePermission() {{
                    setRoleId(roleId);
                }});
                for (RolePermission rolePermission : rolePermissionList) {
                    permissionIdList.add(rolePermission.getPermissionId());
                }
                if (permissionIdList.size() == 0) {
                    permissionList = findAll();
                } else {
                    Example example = new Example(Permission.class);
                    Example.Criteria criteria = example.createCriteria();
                    criteria.andNotIn("permissionId", permissionIdList);
                    criteria.andEqualTo("isDel", "0");
                    permissionList = permissionDao.selectByExample(example);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permissionList;
    }

    @Override
    public List<Permission> findAllByGrade() {

        Example example = new Example(Permission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("permissionLevel","0");
        criteria.andEqualTo("isDel","0");
        List<Permission> permissionList = permissionDao.selectByExample(example);
        if (!ObjectUtils.isEmpty(permissionList)) {
            for (Permission permission : permissionList) {
                Example example2 = new Example(Permission.class);
                Example.Criteria criteria2 = example2.createCriteria();
                criteria2.andEqualTo("parentPermissionId", permission.getPermissionId());
                criteria2.andEqualTo("isDel", "0");
                List<Permission> permissionList2 = permissionDao.selectByExample(example2);
                permission.setPermissionList(permissionList2);
            }
        }
        return permissionList;
    }
}
