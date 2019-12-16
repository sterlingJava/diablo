package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Permission;
import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<UserInfo> findAll();
    UserInfo findById(String userId,String enterpriseId);
    void save(UserInfo userInfo);
    void delete(String userId);
    void update(UserInfo userInfo);
    void addRoleToUser(String userId, String roleId);
    void deleteRoleFromUser(String userId, String roleId);

    PageResult findPage(Integer pageNum, Integer pageSize,String enterpriseId);

    PageResult searchPage(Condition condition, Integer pageNum, Integer pageSize,String enterpriseId);

    List<UserInfo> searchUserInfo(Condition condition);

    UserInfo findByMobile(String mobile);

    boolean checkUserStatus(String userId);

    UserInfo findByName(String s);

    Set<String> getPermissionSetByMobile(String mobile);
}
