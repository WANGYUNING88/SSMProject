package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * //控制器类
 */
@Controller
@RequestMapping(path = "/user")
public class HelloController {

    /**
     * 入门程序demo
     * @return
     */
    @RequestMapping(path = "hello")
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }

    /**
     * RequestMapping注解
     * 1&2.path和value的作用是一样的，
     * 即@RequestMapping(path = "testRequestMapping")=@RequestMapping(value = "testRequestMapping")，
     * 如果只有他们一个可以省略不写
     * 即@RequestMapping(path = "testRequestMapping")，
     * 如何有其他的属性，不可以省略
     * 即@RequestMapping(path = "testRequestMapping" ,method = {RequestMethod.POST})
     * 3.method是一个数组限定访问的方式GET POST PUT等等
     * 即@RequestMapping(path = "testRequestMapping" ,method = {RequestMethod.POST})
     * 4.params用于指定限定请求参数的条件，要求请求中的key和value必须和配置一模一样
     * 即如果params = {"username"}，请求中必须包含username的参数
     * 或者params = {"username=1"}，请求中必须包含username的参数且username必须等于1
     * 5.headers发送的请求中必须包含的请求头
     * @return
     */
    @RequestMapping(path = "testRequestMapping" ,params = {"username=1"} ,headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解...");
        return "success";
    }
}
