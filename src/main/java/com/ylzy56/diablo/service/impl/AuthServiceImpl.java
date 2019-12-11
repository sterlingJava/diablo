package com.ylzy56.diablo.service.impl;

import com.ylzy56.diablo.common.utils.JwtTokenUtil;
import com.ylzy56.diablo.domain.Enterprise;
import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.service.AuthService;
import com.ylzy56.diablo.service.EnterpriseService;
import com.ylzy56.diablo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @Override
    public void register(UserInfo userInfo) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userInfo.getPassword();
        userInfo.setPassword(encoder.encode(rawPassword));
        userInfo.setStatus("1");
        //userToAdd.setRoles(asList("ROLE_ADMIN"));
        //userService.save(userToAdd);
        userService.save(userInfo);
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        UserInfo user = (UserInfo) userDetailsService.loadUserByUsername(username);
        Date createdDate = jwtTokenUtil.getCreatedDateFromToken(token);
        System.out.println("创建时间:---"+createdDate);
        Date expirationDate = jwtTokenUtil.getExpirationDateFromToken(token);
        System.out.println("过期时间:---"+expirationDate);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastModifyTime())){
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }
}