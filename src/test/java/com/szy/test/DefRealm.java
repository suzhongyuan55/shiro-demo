package com.szy.test;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义Realm
 */
public class DefRealm extends AuthorizingRealm {

    Map<String, String> map = new HashMap<String, String>();

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 1.主体传来的认知信息获得用户名
        String name = (String) authenticationToken.getPrincipal();

        //2.通过用户名到数据库获取凭证
        String password = getPassByName(name);
        if (password == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("Suzy", "123", "customerReal");

        return authenticationInfo;
    }

    private String getPassByName(String name) {
        return map.get(name);
    }
}
