package com.suzy.shiro.shirodemo.service;

import com.suzy.shiro.shirodemo.enity.UserInfo;
import com.suzy.shiro.shirodemo.vo.DeleteUserVo;
import com.suzy.shiro.shirodemo.vo.SaveUserVo;
import com.suzy.shiro.shirodemo.vo.UpdateUserVo;

/**
 * @Author Suzy
 * @Date 2021-03-27
 */
public interface UserInfoService {

    UserInfo getUserInfo(Integer id);

    String save(SaveUserVo request);

    String update(UpdateUserVo a);

    String delete(DeleteUserVo b);
}
