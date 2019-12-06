package com.ylzy56.diablo.service;

import com.ylzy56.diablo.domain.Enterprise;

import java.util.List;

public interface EnterpriseService {
    int save(Enterprise enterprise);
    int del(int enterpriseId);
    int update(Enterprise enterprise);
    Enterprise findById(int enterpriseId);
    List<Enterprise> findAll();

    int updateStatus(int enterpriseId, String status);
}
