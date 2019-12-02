package com.ylzy56.diablo.service.impl;

import com.ylzy56.diablo.dao.HerosMapper;
import com.ylzy56.diablo.domain.Heros;
import com.ylzy56.diablo.service.FirstBlood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstBloodImpl implements FirstBlood {
    @Autowired(required = false)
    HerosMapper herosDao;

    @Override
    public String getFirstBlood() {

        return herosDao.selectOne(new Heros(){{setAlias("妲己");}}).getAlias();
//        return "show me the money";
    }
}
