package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.UserInfo;
import java.util.List;

public interface UserService {
    List<UserInfo> findAll();
    UserInfo findById(int userId);
    int save(UserInfo userInfo);
    int delete(int userId);
    int update(UserInfo userInfo);
    int addRoleToUser(int userId, int roleId);
    int deleteRoleFromUser(int userId, int roleId);
}
