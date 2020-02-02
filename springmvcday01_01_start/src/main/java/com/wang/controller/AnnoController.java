package com.wang.controller;

import com.wang.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
@SessionAttributes("test") //把test=成功存入到session域中
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

    /**
     * 获取请求头
     * @param header
     * @return
     */
    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader(name = "Accept") String header){
        System.out.println("testRequestHeader...");
        System.out.println("header: "+header);
        return "success";
    }

    /**
     * 获取cookie 的值
     * @param cookieValue
     * @return
     */
    @RequestMapping("testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID")String cookieValue){
        System.out.println("testCookieValue...");
        System.out.println("cookieValue: "+cookieValue);
        return "success";
    }

    /**
     * ModelAttribute
     * 1.作用在方法上，该方法则优先执行 见showUser1,即方法有返回值
     * 2.作用在方法和参数上, 该方法则优先执行 见showUser2,
     * 即方法没有返回值，传入map集合，并在传入参数加入注解@ModelAttribute(value = "值")
     * @return
     */
    /*@ModelAttribute
    public User showUser1(String uname){
        System.out.println("showUser do it ...");
        //可以通过数据库查询数据（本次模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }
    @ModelAttribute
    public void showUser2(String uname, Map<String,User> map){
        System.out.println("showUser do it ...");
        //可以通过数据库查询数据（本次模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("ab",user);
    }*/
    @RequestMapping("testModelAttribute")
    public String testModelAttribute(@ModelAttribute(value = "ab") User user){
        System.out.println("testModelAttribute...");
        System.out.println(user);
        return "success";
    }

    /**
     * SessionAttributes注解
     * 存值
     * @param model Model类
     * @return
     */
    @RequestMapping("testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes...");
        //底层会存储到request域对象中
        model.addAttribute("test","成功");
        return "success";
    }
    /**
     * getSessionAttributes
     * 取值
     * @param model ModelMap类
     * @return
     */
    @RequestMapping("getSessionAttributes")
    public String getSessionAttributes(ModelMap model){
        System.out.println("getSessionAttributes...");
        String test = (String) model.get("test");
        System.out.println(test);
        return "success";
    }
    /**
     * delSessionAttributes
     * 删除
     * @param status SessionStatus 类
     * @return
     */
    @RequestMapping("delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("delSessionAttributes...");
        status.setComplete();
        return "success";
    }
}
