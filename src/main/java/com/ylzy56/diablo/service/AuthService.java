package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Enterprise;
import com.ylzy56.diablo.domain.UserInfo;

public interface AuthService {
    void register(UserInfo userInfo);
    String login(String username, String password);
    String refresh(String oldToken);
}
