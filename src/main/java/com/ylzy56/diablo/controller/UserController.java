package com.ylzy56.diablo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ylzy56.diablo.annotation.RequiredPermission;
import com.ylzy56.diablo.common.utils.JwtTokenUtil;
import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user")
@Api(value = "/user", description = "用户接口")
@RequiredPermission("ADDRESS") // 权限注解
//@PreAuthorize("hasRole('ROLE_ADMIN')")
//@PreAuthorize("hasAuthority('index')")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询用户列表
     *
     * @return
     *//*
    @GetMapping("/findPage")
    @ApiOperation(value = "分页查询用户列表")
    public PageResult findPage(Integer pageNum, Integer pageSize) {
        try {
            return userService.findPage(pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

    /**
     * 条件查询用户列表
     *
     * @return
     *//*
    @GetMapping("/searchUserInfo")
    @ApiOperation(value = "条件查询用户列表")
    public List<UserInfo> searchUserInfo(Condition condition) {
        try {
            return userService.searchUserInfo(condition);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

    /**
     * 分页条件查询用户列表
     *
     * @return
     */
    @PostMapping("/searchPage")
    @ApiOperation(value = "分页条件查询用户列表")
    public PageResult searchPage(@RequestBody Condition condition, String enterpriseId) {
        try {
            return userService.searchPage(condition, enterpriseId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询指定用户信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "查询指定用户信息")
    public UserInfo findById(String userId) {
        try {
            return userService.findById(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据手机号查询用户
     *
     * @param mobile
     * @return
     */
    @GetMapping("/findByMobile")
    @ApiOperation(value = "根据手机号查询用户")
    public UserInfo findByMobile(String mobile) {
        try {
            return userService.findByMobile(mobile);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加用户
     *
     * @param userInfo
     * @return
     */
    @PostMapping
    @ApiOperation(value = "添加用户")
    public Result save(@RequestBody UserInfo userInfo, String username, String enterpriseId) {
        try {

            userInfo.setCreator(username);
            userInfo.setEnterpriseId(enterpriseId);
            userService.save(userInfo);
            userService.addRoleToUser(userInfo.getUserId(), "f40670e7-fb87-4762-9a43-e11c167256c1");
            return new Result(true, "添加用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加用户失败");
        }
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @DeleteMapping
    @ApiOperation(value = "删除用户")
    public Result delete(String userId) {
        try {
            userService.delete(userId);
            return new Result(true, "删除用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除用户失败");
        }
    }

    /**
     * 更新用户
     *
     * @param userInfo
     * @return
     */
    @PutMapping
    @ApiOperation(value = "更新用户")
    public Result update(@RequestBody UserInfo userInfo, String username) {
        try {
            userInfo.setCreator(username);
            userService.update(userInfo);
            return new Result(true, "更新用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "更新用户失败");
        }
    }

    /**
     * 给指定用户添加角色
     *
     * @param userId,roleId
     * @return
     */
    @PutMapping("/addRoleToUser")
    @ApiOperation(value = "给指定用户添加角色")
    public Result addRoleToUser(String userId, String[] roleIds) {
        try {
            for (String roleId : roleIds) {
                userService.addRoleToUser(userId, roleId);
            }
            return new Result(true, "添加角色成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加角色失败");
        }
    }

    /**
     * 给指定用户删除角色
     *
     * @param userId,roleId
     * @return
     */
    @PutMapping("/deleteRoleFromUser")
    @ApiOperation(value = "给指定用户删除角色")
    public Result deleteRoleFromUser(String userId, String[] roleIds) {
        try {
            for (String roleId : roleIds) {
                userService.deleteRoleFromUser(userId, roleId);
            }
            return new Result(true, "删除角色成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除角色失败");
        }
    }
}
