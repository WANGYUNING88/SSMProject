package com.wang.lesson_4;

import lombok.SneakyThrows;

import java.net.URL;

public class URLDemo01 {
    @SneakyThrows
    public static void main(String[] args) {
        URL url = new URL("http://localhost:8080/wang/1.txt");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getFile());
        System.out.println(url.getFile());
        System.out.println(url.getQuery());
    }
}
