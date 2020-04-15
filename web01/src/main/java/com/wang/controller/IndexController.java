package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class IndexController {

    //在templates目录的所有页面，只能通过controller来跳转

    @RequestMapping("index")
//    @ResponseBody
    public String index(){
        return "index";
    }

    @RequestMapping("test")
//    @ResponseBody
    public String test(Model model){
        model.addAttribute("msg1","hello springboot");
        model.addAttribute("msg2","<h2>hello springboot</h2>");

        model.addAttribute("users", Arrays.asList("WANG","YU","NING"));
        return "test";
    }
}
