package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @RequestMapping("admin/login")
   // @ResponseBody
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password ,
                        Model model,
                        HttpSession session){
        if (username!=null&&username.length()>0&&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:main.html";
        }
        //登录失败
        model.addAttribute("msg","用户名或密码错误");
        return "index";
    }

    @RequestMapping("admin/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:index.html";
    }
}
