package com.ylzy56.diablo.service.impl;


import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo user = userService.findByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("s:" + s);
        System.out.println("username:" + user.getUsername() + ";password:" + user.getPassword());
        System.out.println("size:" + user.getRoles().size());
        System.out.println("role:" + user.getRoles().get(0).getRoleName());
        return user;
    }
}