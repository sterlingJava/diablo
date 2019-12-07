package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

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
     * 条件查询用户列表
     * @return
     */
    @GetMapping("/searchUserInfo")
    @ApiOperation(value = "条件查询用户列表")
    public List<UserInfo> searchUserInfo(Condition condition){
        try {
            return userService.searchUserInfo(condition);
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
    @ApiOperation(value = "分页条件查询用户列表")
    public PageResult searchPage(Condition condition, int pageNum, int pageSize){
        try {
            return userService.searchPage(condition,pageNum,pageSize);
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
     * 根据手机号查询用户
     * @param mobile
     * @return
     */
    @GetMapping("/findByMobile")
    @ApiOperation(value = "根据手机号查询用户")
    public UserInfo findByMobile(String mobile){
        try {
            return userService.findByMobile(mobile);
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
            return new Result(false,"添加用户失败");
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
            return new Result(false,"删除用户失败");
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
            return new Result(false,"更新用户失败");
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
            return new Result(true,"添加角色成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加角色失败");
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
            return new Result(true,"删除角色成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除角色失败");
        }
    }

    @GetMapping("/sendSms")
    @ApiOperation(value = "发送短信验证码")
    public Result sendSms(HttpServletRequest request, String moblie) {
        try {
            //查询手机号是否注册
            Condition condition = new Condition();
            condition.setKeyword(moblie);
            List<UserInfo> userInfoList = searchUserInfo(condition);
            if (userInfoList.size() == 0) {
                //生成6位验证码
                String smscode = (long) (Math.random() * 1000000) + "";
                System.out.println(smscode);
                //发送短信

                //将验证码存到session
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(5 * 60);
                // 将认证码存入SESSION
                session.setAttribute(moblie, smscode);
                return new Result(true,"已发送验证码!");
            }else {
                return new Result(true,"手机号存在!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"发送验证码失败!");
        }
    }

    @GetMapping("/checkSms")
    @ApiOperation(value = "校验短信验证码")
    public Result checkSms(HttpServletRequest request, String mobile, String code) {
        String smsCode = (String) request.getSession().getAttribute(mobile);
        if (!StringUtil.isEmpty(smsCode)) {
            if (smsCode.equals(code)) {
                return new Result(true, "验证码正确!");
            } else {
                return new Result(false, "验证码错误!");
            }
        }else {
            return new Result(false, "验证码无效,请重新获取!");
        }
    }
}
