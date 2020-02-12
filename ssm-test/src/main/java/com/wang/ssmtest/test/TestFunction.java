package com.wang.ssmtest.test;

import com.wang.ssmtest.utils.PasswordUtils;
import org.junit.Test;

import java.util.Date;

public class TestFunction {
    @Test
    public void run1(){
        char s1 = 'a';
        char s2 = 'b';
        int q = 102;
        int i = s1 ^ s2 ^ s2;
        String w = "";
        w+=(char)q;
        System.out.println(w );
    }
    @Test
    public void run3(){
        String s = "wangyuning";
        String encrypt = PasswordUtils.encrypt(s);
        System.out.println(encrypt);
        String dencrypt = PasswordUtils.dencrypt("EwQIBgwZGg0LAQ==");
        System.out.println(dencrypt);
    }
    @Test
    public void run2(){
        String sw = "http://localhost:8080/ssmtest_war_exploded/code?timestamp=";
        String s = "1231312312";
        System.out.println(sw.length());
        sw+=s;
        System.out.println(sw.substring(sw.indexOf("=")+1));
    }
    @Test
    public void run4(){
        String s = "default";
        byte[] bytes = s.getBytes();
        for (int i=0;i<bytes.length;i++){
            System.out.println(bytes[i]);
        }
    }
}
