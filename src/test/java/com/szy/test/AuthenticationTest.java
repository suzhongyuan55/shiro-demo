package com.szy.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("Suzy", "123", "admin");
    }

    /**
     * Shiro认证实例
     * 1. 创建SecurityManager主体认证
     * 2. SecurityManager认证
     * 3. Authorizer认证
     * 4. Realm获取角色认证数据
     */
    @Test
    public void testAuthentication() {
        // 1.构建securityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        // 3.登陆退出认证
        UsernamePasswordToken token = new UsernamePasswordToken("Suzy", "123");
        subject.login(token);
        System.out.println("是否认证成功：" + subject.isAuthenticated());

        // 4.授权验证
        subject.checkRoles("admin");
    }
}
