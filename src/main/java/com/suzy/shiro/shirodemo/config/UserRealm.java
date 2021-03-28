package com.suzy.shiro.shirodemo.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.suzy.shiro.shirodemo.dao.UserInfoDao;
import com.suzy.shiro.shirodemo.enity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * @Author Suzy
 * @Date 2021-03-27
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * 实现授权功能
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        UserInfo userInfo = (UserInfo) subject.getPrincipal();

        // 设置用户权限
        info.addStringPermission(userInfo.getPerms());
        return info;
    }

    /**
     * 实现认证功能
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("登录操作 ==> 执行了认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserInfo userInfo = userInfoDao.selectOne(new QueryWrapper<UserInfo>().eq("user_name", token.getUsername()).eq("status", 1));
        if(Objects.isNull(userInfo)){  //UnknownAccountException
            return null;
        }

        // 资源，密码
        return new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), "");
    }
}
