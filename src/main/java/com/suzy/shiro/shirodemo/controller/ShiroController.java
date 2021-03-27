package com.suzy.shiro.shirodemo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Suzy
 * @Date 2021-03-27
 */
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

    @RequestMapping("/login")
    private String toLogin(){
        return "login...";
    }
}
