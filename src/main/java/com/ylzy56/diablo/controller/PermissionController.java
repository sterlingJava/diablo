package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Permission;
import com.ylzy56.diablo.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permission")
@Api(value = "Permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 添加权限
     * @param permission
     * @return
     */
    @GetMapping("/save")
    @ApiOperation(value = "添加权限")
    public String save(Permission permission){
        return permissionService.save(permission)==0?"添加权限失败":"添加权限成功";
    }

    /**
     * 删除权限
     * @param permissionId
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除权限")
    public String delete(int permissionId){
        return permissionService.delete(permissionId)==0?"删除权限失败":"删除权限成功";
    }

    /**
     * 修改权限
     * @param permission
     * @return
     */
    @GetMapping("/update")
    @ApiOperation(value = "修改权限")
    public String update(Permission permission){
        return permissionService.update(permission)==0?"修改权限失败":"修改权限成功";
    }

    /**
     * 查询所有权限
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有权限")
    public List<Permission> findAll(){
        return permissionService.findAll();
    }

    /**
     * 查询指定权限
     * @param permissionId
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "查询指定权限")
    public Permission findById(int permissionId){
        return permissionService.findById(permissionId);
    }

    /**
     * 查询指定角色所有权限
     * @param roleId
     * @return
     */
    @GetMapping("/findPermissionsByRoleId")
    @ApiOperation(value = "查询指定角色所有权限")
    public List<Permission> findPermissionsByRoleId(int roleId){
        return permissionService.findPermissionsByRoleId(roleId);
    }

    /**
     * 查询指定角色可以添加的权限
     * @param roleId
     * @return
     */
    @GetMapping("/findOtherPermissions")
    @ApiOperation(value = "查询指定角色可以添加的权限")
    public List<Permission> findOtherPermissions(int roleId){
        return permissionService.findOtherPermissions(roleId);
    }


}
