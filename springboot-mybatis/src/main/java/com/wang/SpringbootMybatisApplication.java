package com.wang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.wang.mapper")  //扫描 com.wang.mapper 包下的 mapper 类
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
        System.out.println(
                "     启动成功   \n" +
                "   \\|/ ____ \\|/ \n" +
                "    @~/ ,. \\~@  \n" +
                "   /_( \\__/ )_\\ \n" +
                "      \\__U_/   ");
    }

}
