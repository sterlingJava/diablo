package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Enterprise;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface EnterpriseService {
    void save(Enterprise enterprise);
    void delete(int enterpriseId);
    void update(Enterprise enterprise);
    Enterprise findById(int enterpriseId);
    List<Enterprise> findAll();

    int updateStatus(int enterpriseId, String status,String remark);

    PageResult searchPage(Condition condition, int pageNum, int pageSize);
}
