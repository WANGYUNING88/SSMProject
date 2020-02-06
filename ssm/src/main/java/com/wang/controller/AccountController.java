package com.wang.controller;

import com.wang.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 账户web
 */
@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    /**
     * 测试搭建环境
     * @return
     */
    @RequestMapping("test")
    public String test(){
        System.out.println("【表现层】test");
        return "success";
    }

    /**
     * findAll
     * @return
     */
    @RequestMapping("findAll")
    public String findAll(){
        System.out.println("【表现层】findAll");
        accountService.findAll();
        return "list";
    }
}
