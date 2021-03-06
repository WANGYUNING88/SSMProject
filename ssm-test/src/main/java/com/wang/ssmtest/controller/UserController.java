package com.wang.ssmtest.controller;

import com.wang.ssmtest.bean.Msg;
import com.wang.ssmtest.bean.User;
import com.wang.ssmtest.service.UserService;
import com.wang.ssmtest.service.impl.UserImpl;
import com.wang.ssmtest.utils.ConstUtils;
import com.wang.ssmtest.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

/*    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    @ResponseBody*/

    /**
     * 检查用户名是否可用
     * @param username
     * @return
     */
    @RequestMapping("checkUser")
    @ResponseBody
    public Msg checkUser(@RequestParam(value = "username",defaultValue = ConstUtils.DEFAULT)String username) {
        User user = userService.selectByExample(new User(null, username, null, null));
        if(user==null){
            return Msg.success();
        }else {
            return Msg.fail().add("msg","用户名已存在");
        }
    }
    /**
     * 查询头像名称根据username
     * @param username
     * @return
     */
    @RequestMapping("selectImageByUsername")
    @ResponseBody
    public Msg selectImageByUsername(@RequestParam(value = "username",defaultValue = ConstUtils.DEFAULT)String username) {
        User user = userService.selectByExample(new User(null, username, null, null));
        if(user!=null){
            return Msg.success().add("filename",user.getImage());
        }else {
            return Msg.fail().add("filename",ConstUtils.DEFAULT);
        }
    }

    /**
     * 登录
     * @param session
     * @param user
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public Msg loginUser(HttpSession session, User user){
        String encrypt = PasswordUtils.encrypt(user.getPassword());
        user.setPassword(encrypt);
        System.out.println(user);
        User result = userService.selectByExample(user);
        if(result!=null){
            session.setAttribute("user",result);
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("logout")
    @ResponseBody
    public Msg logoutUser(HttpSession session){
        session.removeAttribute("user");
        return Msg.success();
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("register")
    @ResponseBody
    public Msg registerUser(User user){
        String encrypt = PasswordUtils.encrypt(user.getPassword());
        user.setPassword(encrypt);
        System.out.println(user);
        boolean insert = userService.insert(user);
        if(insert){
            return Msg.success();
        }else {
            return Msg.fail();
        }

    }
}
