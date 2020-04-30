package com.forrest.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.forrest.websocket.util.TheadUtil;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        TheadUtil.MatchingThead thread= new TheadUtil.MatchingThead();
        thread.start();
    }
}
