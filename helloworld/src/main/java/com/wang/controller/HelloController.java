package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello")
public class HelloController {
    @RequestMapping("hello/{i}")
    @ResponseBody
    public String hello(@PathVariable(name="i") int i){
        return String.valueOf(i);
    }
}
