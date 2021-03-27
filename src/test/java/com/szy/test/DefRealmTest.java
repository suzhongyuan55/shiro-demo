package com.szy.test;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

public class DefRealmTest {

    @Test
    public SimpleAuthenticationInfo testAuthentication() {

        DefRealm defRealm = new DefRealm();

        // 1.构建securityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(defRealm);

        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        // 设置加密算法名称
        matcher.setHashAlgorithmName("md5");
        // 设置加密次数
        matcher.setHashIterations(1);
        defRealm.setCredentialsMatcher(matcher);

//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("Suzy", "customRealm");
        // 加盐加密
//        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("Suzy"));
//        return authenticationInfo;
        return null;
    }
}
