package com.szy.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class JdbcRealmTest {
    DruidDataSource dataSource = new DruidDataSource();

    {
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
    }


    @Test
    public void testAuthentication() {

        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        // 设置查询角色权限开关
        jdbcRealm.setPermissionsLookupEnabled(true);

        String sql = "select * from test_user where user_name = ?";
        jdbcRealm.setAuthenticationQuery(sql);

        // 1.构建securityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        // 2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        // 3.登陆退出认证
        UsernamePasswordToken token = new UsernamePasswordToken("Suzy", "123");
        subject.login(token);
        System.out.println("是否认证成功：" + subject.isAuthenticated());

        // 4.授权验证
        subject.checkRoles("admin");

        // 5.权限
        subject.checkPermission("user:update");
    }
}
