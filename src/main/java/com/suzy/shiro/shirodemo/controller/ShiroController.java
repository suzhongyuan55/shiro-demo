package com.suzy.shiro.shirodemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Suzy
 * @Date 2021-03-27
 */
@Slf4j
@RestController
public class ShiroController {

    @RequestMapping("/")
    private String toIndex(Model model){
        model.addAttribute("msg", "hello Shiro");
        return "index";
    }

    @RequestMapping("add")
    private String add(){
        return "add...";
    }

    @RequestMapping("/update")
    private String update(){
        return "update...";
    }

    @PostMapping("/login")
    private String login(@RequestParam("userName") String userName, @RequestParam("password") String password){
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            // 登录
            subject.login(token);
        } catch (UnknownAccountException e) {
            return "用户信息不存在";
        } catch (IncorrectCredentialsException e) {
            return "密码错误";
        } catch (Exception e) {
            return "登录失败！";
        }

        return "登录成功!";
    }

    @GetMapping("/logout")
    private String logout(){
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "注销成功!";
    }
}
