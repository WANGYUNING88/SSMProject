package com.wang.controller;

import com.wang.commons.R;
import com.wang.mapper.UserMapper;
import com.wang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("getAll")
    private List<User> getAll() {
        List<User> all = userMapper.getAll();
        return all;
    }

    @PostMapping(value = "/fileUpload")
    public R fileUpload(@RequestParam(value = "files", required = false) MultipartFile[] files,
                        @RequestParam(value = "username", required = false)String username,
                        @RequestParam(value = "password", required = false)String password) {
        if (files == null || files.length == 0) {
            return R.fail().add("error", "文件不能为空");
        }
        User user = new User();
        try {
            user.setImages(files[0].getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setPassword(password);
        user.setUsername(username);
        int i = userMapper.insertUser(user);
        return i==1?R.success().add("user",user):R.fail().add("user",user);
    }

}
