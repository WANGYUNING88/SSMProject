package com.wang.controller;

import com.wang.domain.Account;
import com.wang.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 请求参数绑定入门
     * @return
     */
    @RequestMapping("testParam")
    public String testParam(String username ,String psd){
        System.out.println("请求参数绑定入门...");
        System.out.println("用户名："+username);
        System.out.println("密码："+psd);
        return "success";
    }
    /**
     * 请求参数绑定
     * form提交把数据封装包javabean中,包含list，map
     * @return
     */
    @RequestMapping("saveAccount")
    public String saveAccount(Account account){
        System.out.println("请求参数绑定...");
        System.out.println(account);
        return "success";
    }
    /**
     * 请求参数绑定
     * 自定义类型转换器
     * @return
     */
    @RequestMapping("saveUser")
    public String saveUser(User user){
        System.out.println("自定义类型转换器...");
        System.out.println(user);
        return "success";
    }
    /**
     * Servlet原生的API
     * @return
     */
    @RequestMapping("testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Servlet原生的API...");
        System.out.println("request: "+request);
        HttpSession session = request.getSession();
        System.out.println("session: "+session);
        ServletContext servletContext = session.getServletContext();
        System.out.println("servletContext: "+servletContext);
        System.out.println("response: "+response);
        return "success";
    }

}
