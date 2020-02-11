package com.wang.ssmtest.service;

import com.wang.ssmtest.bean.User;

public interface UserService {
    /**
     * 根据主键查找user
     * @return
     */
    public User selectByPrimaryKey(Integer id);

    /**
     * 查询（登录）
     * @param user
     * @return
     */
    public User selectByExample(User user);

    /**
     * 插入（注册）
     * @param user
     * @return
     */
    public boolean insert(User user);
}
