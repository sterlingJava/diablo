package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Enterprise;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;

import java.util.List;

public interface EnterpriseService {
    void save(Enterprise enterprise);
    void delete(String enterpriseId);
    void update(Enterprise enterprise);
    Enterprise findById(String enterpriseId);

    void updateStatus(String enterpriseId, String status,String remark);

    PageResult searchPage(Condition condition);
}
