package com.ylzy56.diablo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylzy56.diablo.dao.EnterpriseMapper;
import com.ylzy56.diablo.dao.UserInfoMapper;
import com.ylzy56.diablo.domain.Enterprise;
import com.ylzy56.diablo.domain.Role;
import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.domain.UserRole;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.service.EnterpriseService;
import com.ylzy56.diablo.service.RoleService;
import com.ylzy56.diablo.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired(required = false)
    private EnterpriseMapper enterpriseDao;

    @Autowired(required = false)
    private UserInfoMapper userInfoDao;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @Override
    public void save(Enterprise enterprise) {
        enterprise.setStatus("0");
        enterprise.setIsDel("0");
        enterprise.setApplyTime(new Date());
        enterpriseDao.insertSelective(enterprise);
        UserInfo userInfo = userService.findByMobile(enterprise.getMobile());
        userInfo.setName(enterprise.getCorpName());
        userInfo.setEnterpriseId(enterprise.getEnterpriseId());
        userInfo.setLevel("0");
        userInfo.setCreator("自主注册");
        userInfoDao.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void delete(String enterpriseId) {
        //1.查询需要删除的用户企业
        Example example = new Example(Enterprise.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("enterpriseId",enterpriseId);
        criteria.andEqualTo("isDel","0");
        Enterprise enterprise = enterpriseDao.selectOneByExample(example);
        if (!ObjectUtils.isEmpty(enterprise)) {
            enterprise.setIsDel("1");
            //2.删除企业信息
            enterpriseDao.updateByPrimaryKeySelective(enterprise);
        }
    }

    @Override
    public void update(Enterprise enterprise) {
        enterpriseDao.updateByPrimaryKeySelective(enterprise);
    }

    @Override
    public Enterprise findById(String enterpriseId) {
        //1.根据id查询企业信息
        Example example = new Example(Enterprise.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("enterpriseId",enterpriseId);
        criteria.andEqualTo("isDel","0");
        Enterprise enterprise = enterpriseDao.selectOneByExample(example);
        return enterprise;
    }

    @Override
    public void updateStatus(String enterpriseId, String status,String remark) {
        try {
            Enterprise enterprise = enterpriseDao.selectByPrimaryKey(enterpriseId);
            if (enterprise != null) {
                enterprise.setReviewTime(new Date());
                enterprise.setStatus(status);
                enterprise.setNotes(remark);
                //1.根据企业id查询用户信息
                Example example = new Example(UserInfo.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("enterpriseId",enterpriseId);
                criteria.andEqualTo("isDel","0");
                UserInfo userInfo = userInfoDao.selectOneByExample(example);
                if (!ObjectUtils.isEmpty(userInfo)) {
                    if ("1".equals(status)) {
                        userInfo.setStatus("0");
                        userInfoDao.updateByPrimaryKeySelective(userInfo);
                        userService.addRoleToUser(userInfo.getUserId(),"3281f868-f273-438b-a1c4-822ae9cfa8c2");
                    }
                    if ("2".equals(status)){
                        userInfo.setStatus("1");
                        userInfoDao.updateByPrimaryKeySelective(userInfo);
                    }
                }
            }
            enterpriseDao.updateByPrimaryKeySelective(enterprise);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PageResult searchPage(Condition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageNum());
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
