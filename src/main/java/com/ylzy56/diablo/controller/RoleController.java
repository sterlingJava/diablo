package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Role;
import com.ylzy56.diablo.domain.Role;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(value = "/role",description = "角色接口")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "添加角色")
    public Result save(@RequestBody Role role,String username,String enterpriseId){
        try {
            role.setCreator(username);
            role.setEnterpriseId(enterpriseId);
            roleService.save(role);
            return new Result(true,"添加角色成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加角色失败");
        }
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @DeleteMapping
    @ApiOperation(value = "删除角色")
    public Result delete(String roleId){
        try {
            roleService.delete(roleId);
            return new Result(true,"删除角色成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除角色失败");
        }
    }
    /**
     * 更新角色
     * @param role
     * @return
     */
    @PutMapping
    @ApiOperation(value = "更新角色")
    public Result update(@RequestBody Role role,String username){
        try {
            role.setLastModifier(username);
            roleService.update(role);
            return new Result(true,"更新角色成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"更新角色失败");
        }
    }
    /**
     * 查询所有角色列表
     * @return
     *//*
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有角色列表")
    public List<Role> findAll(){
        try {
            return roleService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

    /**
     * 分页条件查询角色列表
     * @return
     */
    @GetMapping("/searchPage")
    @ApiOperation(value = "分页条件查询角色列表")
    public PageResult searchPage( Condition condition,String enterpriseId){
        try {
            return roleService.searchPage(condition,enterpriseId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询指定角色信息
     * @param roleId
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "查询指定角色信息")
    public Role findById(String roleId){
        try {
            return roleService.findById(roleId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 给指定角色添加权限
     * @param roleId,permissionId
     * @return
     */
    @PutMapping("/addPermissionToRole")
    @ApiOperation(value = "给指定角色添加权限")
    public Result addPermissionToRole(String roleId,String[] permissionIds){
        try {
            for (String permissionId : permissionIds) {
                roleService.addPermissionToRole(roleId, permissionId);
            }
            return new Result(true,"添加权限成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"添加权限失败");
        }
    }

    /**
     * 给指定角色删除权限
     * @param roleId,permissionId
     * @return
     */
    @PutMapping("/deletePermissionFromRole")
    @ApiOperation(value = "给指定角色删除权限")
    public Result deletePermissionFromRole(String roleId,String[] permissionIds){
        try {
            for (String permissionId : permissionIds) {
                roleService.deletePermissionFromRole(roleId, permissionId);
            }
            return new Result(true,"删除权限成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除权限成功");
        }
    }

    /**
     * 查询指定用户所有角色
     * @param userId
     * @return
     */
    @GetMapping("/findRolesByUserId")
    @ApiOperation(value = "查询指定用户所有角色")
    public List<Role> findRolesByUserId(String userId){
        return roleService.findRolesByUserId(userId);
    }

    /**
     * 查询指定用户可以添加的角色
     * @param userId
     * @return
     */
    @GetMapping("/findOtherRoles")
    @ApiOperation(value = "查询指定用户可以添加的角色")
    public List<Role> findOtherRoles(String userId){
        return roleService.findOtherRoles(userId);
    }
}
