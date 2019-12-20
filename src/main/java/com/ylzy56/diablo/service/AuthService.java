package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Enterprise;
import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.domain.entity.Result;

public interface AuthService {
    void register(UserInfo userInfo);
    Result login(String username, String password);
    String refresh(String oldToken);
}
