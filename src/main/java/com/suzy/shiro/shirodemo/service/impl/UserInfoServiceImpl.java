package com.suzy.shiro.shirodemo.service.impl;

import com.suzy.shiro.shirodemo.dao.UserInfoDao;
import com.suzy.shiro.shirodemo.enity.UserInfo;
import com.suzy.shiro.shirodemo.service.UserInfoService;
import com.suzy.shiro.shirodemo.vo.SaveUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Suzy
 * @Date 2021-03-27
 */
@Slf4j
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo getUserInfo(Integer id) {
        return userInfoDao.selectById(id);
    }

    @Override
    public String save(SaveUserVo request) {
        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(request.getUserName());
            userInfo.insert();
        } catch (Exception e) {
            log.error(e.getMessage());
            return "error!";
        }
        return "success!";
    }
}
