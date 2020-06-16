package com.wang.lesson_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) throws UnknownHostException {
        //查询本机地址
        System.out.println(InetAddress.getByName("127.0.0.1"));
        System.out.println(InetAddress.getByName("localhost"));
        System.out.println(InetAddress.getLocalHost());

    }
}
