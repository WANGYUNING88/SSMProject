package com.wang.lesson_4;

import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLDown {
    @SneakyThrows
    public static void main(String[] args) {
        //下载地址
        URL url = new URL(" https://m10.music.126.net/20200617103404/3ffb9ddbb30a9537e311623312a72688/yyaac/obj/wonDkMOGw6XDiTHCmMOi/2829331736/7d43/362e/8ac1/303ce40f073d50765c5c79f31ee3dc47.m4a");
        //2. 连接到这个资源
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("helloworld/net_study/303ce40f073d50765c5c79f31ee3dc47.m4a");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fos.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
