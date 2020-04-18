package com.wang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息，并显示
    @GetMapping("userList")
    public List<Map<String,Object>> userList(){
        String sql = "SELECT * FROM `user`";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    //添加用户
    @GetMapping("addUser")
    public String addUser(){
        String sql = "INSERT INTO `mybatis`.`user` (username,PASSWORD,image) VALUE ('王余柠','VVdVVUBa','default')";
        int n = jdbcTemplate.update(sql);
        return  n>0?"insert-ok":"insert-no";
    }

    //修改用户
    @GetMapping("updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "UPDATE `mybatis`.`user` SET username = ? WHERE id = ?";

        //封装参数
        Object[] objects = new Object[2];
        objects[0] = "王"+Math.random();
        objects[1] = id;
        int n = jdbcTemplate.update(sql,objects);
        return  n>0?"update-ok":"update-no";
    }

    //添加用户
    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "DELETE FROM `mybatis`.`user` WHERE id = ?";
        int n = jdbcTemplate.update(sql,id);
        return  n>0?"delete-ok":"delete-no";
    }
}
