package com.wang.controller;

import com.wang.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class ExceptionController {
    @RequestMapping("testException")
    public String testException() throws SysException {
        System.out.println("【testException】执行了...");

        try {
            //模拟异常
            int i = 10 / 0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //弹出自定义异常信息
            throw new SysException("系统错误");
        }
        return "success";
    }

}
