package com.wang.ssmtest.service.impl;

import com.wang.ssmtest.bean.User;
import com.wang.ssmtest.dao.UserMapper;
import com.wang.ssmtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User selectByExample(User user) {
        return userMapper.selectByExample(user);
    }

    public boolean insert(User user) {
        int insert = userMapper.insert(user);
        return insert==1;
    }
}
