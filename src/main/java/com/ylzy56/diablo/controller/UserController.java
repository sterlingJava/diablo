package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "User")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户列表
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有用户列表")
    public List<UserInfo> findAll(){
        return userService.findAll();
    }

    /**
     * 查询指定用户信息
     * @param userId
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "查询指定用户信息")
    public UserInfo findById(int userId){
        return userService.findById(userId);
    }

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    @GetMapping("/save")
    @ApiOperation(value = "添加用户")
    public String save(UserInfo userInfo){
        return userService.save(userInfo)==0?"添加用户失败":"添加用户成功";
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除用户")
    public String delete(int userId){
        return userService.delete(userId)==0?"删除用户失败":"删除用户成功";
    }

    /**
     * 更新用户
     * @param userInfo
     * @return
     */
    @GetMapping("/update")
    @ApiOperation(value = "更新用户")
    public String update(UserInfo userInfo){
        return userService.update(userInfo)==0?"更新用户失败":"更新用户成功";
    }

    /**
     * 给指定用户添加角色
     * @param userId,roleId
     * @return
     */
    @GetMapping("/addRoleToUser")
    @ApiOperation(value = "给指定用户添加角色")
    public String addRoleToUser(int userId,int roleId){
        return userService.addRoleToUser(userId,roleId)==0?"添加权限失败":"添加权限成功";
    }

    /**
     * 给指定用户删除角色
     * @param userId,roleId
     * @return
     */
    @GetMapping("/deleteRoleFromUser")
    @ApiOperation(value = "给指定用户删除角色")
    public String deleteRoleFromUser(int userId,int roleId){
        return userService.deleteRoleFromUser(userId,roleId)==0?"删除权限失败":"删除权限成功";
    }
}
