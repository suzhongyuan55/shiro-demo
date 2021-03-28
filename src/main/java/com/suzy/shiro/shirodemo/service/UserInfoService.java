package com.suzy.shiro.shirodemo.service;

import com.suzy.shiro.shirodemo.enity.UserInfo;
import com.suzy.shiro.shirodemo.vo.*;

import java.util.List;

/**
 * @Author Suzy
 * @Date 2021-03-27
 */
public interface UserInfoService {

    UserInfo getUserInfo(Integer id);

    String save(SaveUserVo request);

    String update(UpdateUserVo a);

    String delete(DeleteUserVo b);

    /**
     * 获取所有用户信息
     * @return
     * @param c
     */
    AllUserPageVo all(SelectNameVO c);
}
