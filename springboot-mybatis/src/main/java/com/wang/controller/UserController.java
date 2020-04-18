package com.wang.controller;

import com.wang.mapper.UserMapper;
import com.wang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("getAll")
    private List<User> getAll(){
        List<User> all = userMapper.getAll();
        return all;
    }

}
