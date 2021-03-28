package com.suzy.shiro.shirodemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.suzy.shiro.shirodemo.dao.UserInfoDao;
import com.suzy.shiro.shirodemo.enity.UserInfo;
import com.suzy.shiro.shirodemo.service.UserInfoService;
import com.suzy.shiro.shirodemo.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    //修改
    @Override
    public String update(UpdateUserVo a) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(a.getUseName());
        userInfo.setUserId(a.getUserId());
        userInfo.updateById();
        return "cg";
    }
    //删除
    @Override
    public String delete(DeleteUserVo b){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(b.getUsername());
        userInfo.setUserId(b.getId());
        userInfo.deleteById();
        return "成功";
    }

    @Override
    public AllUserPageVo all(SelectNameVO c) {
        List<UserInfo> userInfos = userInfoDao.selectList(new QueryWrapper<UserInfo>()
                .like("user_name", c.getUserName()).like("real_name", c.getRealName())
                // limit 3,3
                .last("limit " + c.getLimit() + "," + c.getSize()));
        Integer count = userInfoDao.selectCount(new QueryWrapper<UserInfo>()
                .like("user_name", c.getUserName()).like("real_name", c.getRealName()));

        // 设置对象返回
        AllUserPageVo result = new AllUserPageVo();
        result.setPage(c.getPage());
        result.setSize(c.getSize());
        result.setCount(count);
        result.setData(userInfos);
        return result;
    }

}
