package com.suzy.shiro.shirodemo.controller;

import com.suzy.shiro.shirodemo.enity.UserInfo;
import com.suzy.shiro.shirodemo.service.UserInfoService;
import com.suzy.shiro.shirodemo.vo.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public UserInfo getUserInfo(@PathVariable Integer id) {

        return userInfoService.getUserInfo(id);
    }

    @PostMapping("save")
    public String save(@RequestBody SaveUserVo request) {

        return userInfoService.save(request);
    }

    @PostMapping("update")
    public String update(@RequestBody UpdateUserVo a) {
        return userInfoService.update(a);
    }

    @PostMapping("delete")
    public String delete(@RequestBody DeleteUserVo b) {
        return userInfoService.delete(b);
    }

    @GetMapping("all")
    public AllUserPageVo all(@RequestBody SelectNameVO c) {
        return userInfoService.all(c);
    }
}
