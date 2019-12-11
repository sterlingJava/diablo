package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Permission;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
@Api(value = "权限")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 添加权限
     * @param permission
     * @return
     */
    @PostMapping
    @ApiOperation(value = "添加权限")
    public Result save(Permission permission){
        try {
            permissionService.save(permission);
            return new Result(true,"添加权限成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加权限失败");
        }
    }

    /**
     * 删除权限
     * @param permissionId
     * @return
     */
    @DeleteMapping
    @ApiOperation(value = "删除权限")
    public Result delete(String permissionId){
        try {
            permissionService.delete(permissionId);
            return new Result(true,"删除权限成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除权限失败");
        }
    }

    /**
     * 修改权限
     * @param permission
     * @return
     */
    @PutMapping
    @ApiOperation(value = "修改权限")
    public Result update(Permission permission){
        try {
            permissionService.update(permission);
            return new Result(true,"修改权限成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改权限失败");
        }
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
    public Permission findById(String permissionId){
        return permissionService.findById(permissionId);
    }

    /**
     * 查询指定角色所有权限
     * @param roleId
     * @return
     */
    @GetMapping("/findPermissionsByRoleId")
    @ApiOperation(value = "查询指定角色所有权限")
    public List<Permission> findPermissionsByRoleId(String roleId){
        return permissionService.findPermissionsByRoleId(roleId);
    }

    /**
     * 查询指定角色可以添加的权限
     * @param roleId
     * @return
     */
    @GetMapping("/findOtherPermissions")
    @ApiOperation(value = "查询指定角色可以添加的权限")
    public List<Permission> findOtherPermissions(String roleId){
        return permissionService.findOtherPermissions(roleId);
    }


}
