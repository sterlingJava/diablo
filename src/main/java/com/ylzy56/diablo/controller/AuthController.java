package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Enterprise;
import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.AuthService;
import com.ylzy56.diablo.service.EnterpriseService;
import com.ylzy56.diablo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/auth")
@Api(value = "/auth",description = "验证接口")
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Autowired
    private EnterpriseService enterpriseService;

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String createAuthenticationToken(
            String username,String password
    ) throws AuthenticationException{
        //  @RequestBody JwtAuthenticationRequest authenticationRequest
        final String token = authService.login(username,password);

        // Return the token
        //return ResponseEntity.ok(new JwtAuthenticationResponse(token));
        return token;
    }
    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public String refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException{
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            //return ResponseEntity.badRequest().body(null);
            return null;
        } else {
            //return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
            return refreshedToken;
        }
    }

    @ApiOperation(value = "注册(参数手机号和密码)")
    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public Result register(@RequestBody UserInfo userInfo) throws AuthenticationException{
        try {
             authService.register(userInfo);
             return new Result(true,"注册成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"注册失败!");
        }
    }
    @ApiOperation(value = "找回密码(参数新密码和手机号或者用户id)")
    @PutMapping(value = "/auth/updatePassword")
    public Result updatePassword(@RequestBody UserInfo userInfo) throws AuthenticationException{
        try {
            userService.update(userInfo);
            return new Result(true,"修改密码成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改密码失败!");
        }
    }
    @ApiOperation(value = "注册企业信息")
    @RequestMapping(value = "/auth/enterprise", method = RequestMethod.POST)
    public Result register(Enterprise enterprise) throws AuthenticationException{
        try {
            enterpriseService.save(enterprise);
            return new Result(true,"注册成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"注册失败!");
        }
    }

    @GetMapping("/auth/sendSms")
    @ApiOperation(value = "发送短信验证码")
    public Result sendSms(HttpServletRequest request, String moblie) {
        try {
            //查询手机号是否注册
            Condition condition = new Condition();
            condition.setKeyword(moblie);
            List<UserInfo> userInfoList = userService.searchUserInfo(condition);
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

    @GetMapping("/auth/checkSms")
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
