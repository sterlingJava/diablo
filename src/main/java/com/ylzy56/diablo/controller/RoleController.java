package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Role;
import com.ylzy56.diablo.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(value = "Role")
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
    public String save(Role role){
        return roleService.save(role)==0?"添加角色失败":"添加角色成功";
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除角色")
    public String delete(int roleId){
        return roleService.delete(roleId)==0?"删除角色失败":"删除角色成功";
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @GetMapping("/update")
    @ApiOperation(value = "修改角色")
    public String update(Role role){
        return roleService.update(role)==0?"修改角色失败":"修改角色成功";
    }

    /**
     * 查询所有角色
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有角色")
    public List<Role> findAll(){
        return roleService.findAll();
    }

    /**
     * 查询指定角色
     * @param roleId
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "查询指定角色")
    public Role findById(int roleId){
        return roleService.findById(roleId);
    }

    /**
     * 给指定角色添加权限
     * @param roleId,permissionId
     * @return
     */
    @GetMapping("/addPermissionToRole")
    @ApiOperation(value = "给指定角色添加权限")
    public String addPermissionToRole(int roleId,int permissionId){
        return roleService.addPermissionToRole(roleId,permissionId)==0?"添加权限失败":"添加权限成功";
    }

    /**
     * 给指定角色删除权限
     * @param roleId,permissionId
     * @return
     */
    @GetMapping("/deletePermissionFromRole")
    @ApiOperation(value = "给指定角色删除权限")
    public String deletePermissionFromRole(int roleId,int permissionId){
        return roleService.deletePermissionFromRole(roleId,permissionId)==0?"删除权限失败":"删除权限成功";
    }

    /**
     * 查询指定用户所有角色
     * @param userId
     * @return
     */
    @GetMapping("/findRolesByUserId")
    @ApiOperation(value = "查询指定用户所有角色")
    public List<Role> findRolesByUserId(int userId){
        return roleService.findRolesByUserId(userId);
    }

    /**
     * 查询指定用户可以添加的角色
     * @param userId
     * @return
     */
    @GetMapping("/findOtherRoles")
    @ApiOperation(value = "查询指定用户可以添加的角色")
    public List<Role> findOtherRoles(int userId){
        return roleService.findOtherRoles(userId);
    }
}
