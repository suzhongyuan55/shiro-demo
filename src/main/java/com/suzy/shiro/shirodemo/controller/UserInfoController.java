package com.suzy.shiro.shirodemo.controller;

import com.suzy.shiro.shirodemo.enity.UserInfo;
import com.suzy.shiro.shirodemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Suzy
 * @Date 2021-03-27
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("get/{id}")
    public UserInfo getUserInfo(@RequestParam Integer id) {

        return userInfoService.getUserInfo(id);
    }
}
