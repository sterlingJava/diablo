package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.EnterpriseMapper;
import com.ylzy56.diablo.dao.UserInfoMapper;
import com.ylzy56.diablo.domain.Enterprise;
import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired(required = false)
    private EnterpriseMapper enterpriseDao;

    @Autowired(required = false)
    private UserInfoMapper userInfoDao;

    @Override
    public void save(Enterprise enterprise) {
        enterprise.setStatus("0");
        enterprise.setIsDel("0");
        enterpriseDao.insert(enterprise);
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(enterprise.getCorpName());
        userInfo.setMobile(enterprise.getMobile());
        userInfo.setEnterpriseId(enterprise.getEnterpriseId());
        userInfo.setPassword(enterprise.getPassword());
        userInfo.setLevel("0");
        userInfo.setStatus("1");
        userInfo.setIsDel("0");
        userInfoDao.insert(userInfo);
    }

    @Override
    public void delete(int enterpriseId) {
        enterpriseDao.deleteByPrimaryKey(enterpriseId);
    }

    @Override
    public void update(Enterprise enterprise) {
        enterpriseDao.updateByPrimaryKey(enterprise);
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
        List<Enterprise> enterpriseList = null;
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
            if (enterprise != null) {
                enterprise.setStatus(status);
                if ("1".equals(status)) {
                    UserInfo userInfo = userInfoDao.selectOne(new UserInfo() {{
                        setEnterpriseId(enterpriseId);
                    }});
                    userInfo.setStatus("0");
                    userInfoDao.updateByPrimaryKey(userInfo);
                }
            }
            return enterpriseDao.updateByPrimaryKey(enterprise);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public PageResult searchPage(Condition condition, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmpty(condition.getKeyword())) {
            criteria.orLike("name", "%" + condition.getKeyword() + "%");
            criteria.orLike("type", "%" + condition.getKeyword() + "%");
        }
        if (!StringUtil.isEmpty(condition.getStatus())) {
            criteria.andEqualTo("status", condition.getStatus());
        }
        criteria.andEqualTo("isDel", 0);
        Page<Enterprise> page = (Page<Enterprise>) enterpriseDao.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
