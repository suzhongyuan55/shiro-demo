package com.suzy.shiro.shirodemo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Suzy
 * @Date 2021-03-27
 */
@Slf4j
@Configuration
public class ShiroConfig {

    /**
     * ShiroFilterFactoryBean:3
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);

        // 添加Shirog内置过滤器
        /**
         * anon：无需认证即可访问
         * authc：必须认证才能访问
         * user：必须拥有 记住我 功能才能访问
         * perms：拥有对某个资源的权限才能访问
         */
        // 拦截map
        Map<String, String> filterDefinitionMap = new LinkedHashMap<>();

        // 设置权限
        filterDefinitionMap.put("/user/save", "perms[user:save]");
        filterDefinitionMap.put("/user/get", "perms[user:get]");
        bean.setFilterChainDefinitionMap(filterDefinitionMap);

        // 设置登录请求
        bean.setLoginUrl("/login");
        log.info(" ==> 执行了授权认证操作");
        return bean;
    }

    /**
     * DafaultWebSecurityManager:2
     *
     * @param userRealm
     * @return
     * @Qyalifier 从Spring容器中获取对象
     */
    @Bean(name = "getDefaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建了 realm 对象 ，需要自定义类:1
     * @return
     */
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
