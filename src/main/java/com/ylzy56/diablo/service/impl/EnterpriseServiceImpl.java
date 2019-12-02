package com.ylzy56.diablo.service.impl;

import com.ylzy56.diablo.dao.EnterpriseMapper;
import com.ylzy56.diablo.dao.UserInfoMapper;
import com.ylzy56.diablo.domain.Enterprise;
import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired(required = false)
    private EnterpriseMapper enterpriseDao;

    @Autowired(required = false)
    private UserInfoMapper userInfoDao;

    @Override
    public int save(Enterprise enterprise) {
        try {
            return enterpriseDao.insert(enterprise);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int del(int enterpriseId) {
        try {
            return enterpriseDao.deleteByPrimaryKey(enterpriseId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(Enterprise enterprise) {
        try {
            return enterpriseDao.updateByPrimaryKey(enterprise);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Enterprise findById(int enterpriseId) {
        Enterprise enterprise = null;
        try {
            enterprise = enterpriseDao.selectByPrimaryKey(enterpriseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enterprise;
    }

    @Override
    public List<Enterprise> findAll() {
        List<Enterprise> enterpriseList=null;
        try {
            enterpriseList = enterpriseDao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enterpriseList;
    }

    @Override
    public int updateStatus(int enterpriseId, String status) {
        try {
            Enterprise enterprise = enterpriseDao.selectByPrimaryKey(enterpriseId);
            if (enterprise!=null){
                enterprise.setStatus(status);
                if ("0".equals(status)){
                    UserInfo userInfo = new UserInfo();
                    userInfo.setUsername(enterprise.getName());
                    userInfo.setMobile(enterprise.getMobile());
                    userInfo.setEnterpriseId(enterpriseId);
                    userInfo.setPassword(enterprise.getPassword());
                    userInfo.setLevel("0");
                    userInfoDao.insert(userInfo);
                }
            }
            return enterpriseDao.updateByPrimaryKey(enterprise);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
