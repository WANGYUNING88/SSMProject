package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/anno")
public class AnnoController {

    /**
     * testRequestParam
     * @return
     */
    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam(name="name") String username){
        System.out.println("testRequestParam...");
        System.out.println("username: "+username);
        return "success";
    }
    /**
     * 获取到请求体中内容
     * @return
     */
    @RequestMapping("testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("testRequestBody...");
        System.out.println("username: "+body);
        return "success";
    }
    /**
     * PathVariable注解
     * @return
     */
    @RequestMapping("testPathVariable/{suid}")
    public String testPathVariable(@PathVariable(name = "suid")String id){
        System.out.println("testPathVariable...");
        System.out.println("suid: "+id);
        return "success";
    }
    /**
     * POST 请求保存
     * @return
     */
    @RequestMapping(value = "testRestfulPOST/{id}" ,method = RequestMethod.POST)
    public String testRestfulURLPOST(@PathVariable(name = "id")String id,String username){
        System.out.println("[POST]...");
        System.out.println("id: " + id);
        System.out.println("username: " + username);
        return "success";
    }
    /**
     * POST 请求更新
     * @return
     */
    @RequestMapping(value = "testRestfulPUT/{id}" ,method = RequestMethod.PUT)
    public String testRestfulURLPUT(@PathVariable(name = "id")String id,String username){
        System.out.println("[PUT]...");
        System.out.println("id: " + id);
        System.out.println("username: " + username);
        return "success";
    }
    /**
     * POST 请求 删除
     * @return
     */
    @RequestMapping(value = "testRestfulDELETE/{id}" ,method = RequestMethod.DELETE)
    public String testRestfulURLDELETE(@PathVariable(name = "id")String id, String username){
        System.out.println("[DELETE]...");
        System.out.println("id: " + id);
        System.out.println("username: " + username);
        return "success";
    }
    /**
     * POST 请求 查询
     * @return
     */
    @RequestMapping(value = "testRestfulGET/{id}" ,method = RequestMethod.GET)
    public String testRestfulURLGET(@PathVariable(name = "id")String id, String username){
        System.out.println("[GET]...");
        System.out.println("id: " + id);
        System.out.println("username: " + username);
        return "success";
    }
}
