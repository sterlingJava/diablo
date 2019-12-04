package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        try {
            return userService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 分页查询用户列表
     * @return
     */
    @GetMapping("/findPage")
    @ApiOperation(value = "分页查询用户列表")
    public PageResult findPage(int pageNum, int pageSize){
        try {
            return userService.findPage(pageNum,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 分页条件查询用户列表
     * @return
     */
    @GetMapping("/searchPage")
    @ApiOperation(value = "分页查询用户列表")
    public PageResult searchPage(String keyword,int pageNum, int pageSize){
        try {
            return userService.searchPage(keyword,pageNum,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询指定用户信息
     * @param userId
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "查询指定用户信息")
    public UserInfo findById(int userId){
        try {
            return userService.findById(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "添加用户")
    public Result save(UserInfo userInfo){
        try {
            userService.save(userInfo);
            return new Result(true,"添加用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"添加用户失败");
        }
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除用户")
    public Result delete(int userId){
        try {
            userService.delete(userId);
            return new Result(true,"删除用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除用户失败");
        }
    }

    /**
     * 更新用户
     * @param userInfo
     * @return
     */
    @GetMapping("/update")
    @ApiOperation(value = "更新用户")
    public Result update(UserInfo userInfo){
        try {
            userService.update(userInfo);
            return new Result(true,"更新用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"更新用户失败");
        }
    }

    /**
     * 给指定用户添加角色
     * @param userId,roleId
     * @return
     */
    @GetMapping("/addRoleToUser")
    @ApiOperation(value = "给指定用户添加角色")
    public Result addRoleToUser(int userId,int roleId){
        try {
            userService.addRoleToUser(userId,roleId);
            return new Result(true,"删除用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除用户成功");
        }
    }

    /**
     * 给指定用户删除角色
     * @param userId,roleId
     * @return
     */
    @GetMapping("/deleteRoleFromUser")
    @ApiOperation(value = "给指定用户删除角色")
    public Result deleteRoleFromUser(int userId,int roleId){
        try {
            userService.deleteRoleFromUser(userId,roleId);
            return new Result(true,"删除用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除用户成功");
        }
    }
}
