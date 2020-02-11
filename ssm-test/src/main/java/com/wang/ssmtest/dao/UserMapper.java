package com.wang.ssmtest.dao;

import com.wang.ssmtest.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * 根据主键查找user
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 查询（登录）
     * @param user
     * @return
     */
    User selectByExample(User user);

    /**
     * 插入（注册）
     * @param user
     * @return
     */
    int insert(User user);

}
