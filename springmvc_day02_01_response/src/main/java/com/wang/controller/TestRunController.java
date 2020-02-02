package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestRunController {
    @RequestMapping("testRun")
    public String testRun(){
        System.out.println("【testRun】执行了...");
        return "success";
    }
}
