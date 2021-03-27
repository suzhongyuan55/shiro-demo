package com.suzy.shiro.shirodemo.service.impl;

import com.suzy.shiro.shirodemo.dao.UserInfoDao;
import com.suzy.shiro.shirodemo.enity.UserInfo;
import com.suzy.shiro.shirodemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Suzy
 * @Date 2021-03-27
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;


    @Override
    public UserInfo getUserInfo(Integer id) {
        return userInfoDao.selectById(id);
    }
}
