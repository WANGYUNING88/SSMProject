package com.wang.mapper;

import com.wang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper //这个注解表示这是一个 mybatis 的 mapper 类
@Repository
public interface UserMapper {
    List<User> getAll();

    User getUserById(int id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
