package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface UserService {
    List<UserInfo> findAll();
    UserInfo findById(int userId);
    void save(UserInfo userInfo);
    void delete(int userId);
    void update(UserInfo userInfo);
    void addRoleToUser(int userId, int roleId);
    void deleteRoleFromUser(int userId, int roleId);

    PageResult findPage(int pageNum, int pageSize);

    PageResult searchPage(String keyword, int pageNum, int pageSize);
}
