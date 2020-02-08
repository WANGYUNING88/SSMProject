package com.wang.ssmtest.test;

import org.junit.Test;

import java.util.Date;

public class TestFunction {
    @Test
    public void run1(){
        Date date = new Date();
        System.out.println(date.getTime());
    }
    @Test
    public void run2(){
        String sw = "http://localhost:8080/ssmtest_war_exploded/code?timestamp=";
        String s = "1231312312";
        System.out.println(sw.length());
        sw+=s;
        System.out.println(sw.substring(sw.indexOf("=")+1));
    }
}
