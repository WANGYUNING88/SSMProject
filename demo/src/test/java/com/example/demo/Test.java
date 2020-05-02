package com.example.demo;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        String name = "C:\\Users\\24719\\Desktop\\jvm.png";
        File file = new File(name);
        String name1 = file.getName();
        System.out.println(name1);
    }
}
