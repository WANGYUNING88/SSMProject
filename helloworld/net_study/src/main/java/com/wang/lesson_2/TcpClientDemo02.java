package com.wang.lesson_2;

import java.io.*;
import java.net.Socket;
/**
 * 客户端02
 * 文件发送
 */
public class TcpClientDemo02 {
    @lombok.SneakyThrows
    public static void main(String[] args) {
        //创建连接
        Socket socket = new Socket("127.0.0.1", 9000);
        //输出流
        OutputStream os = socket.getOutputStream();
        //读取文件
        FileInputStream fis = new FileInputStream(new File("helloworld/net_study/test.gif"));
        //写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        //通知服务器我已经发送完了
        socket.shutdownOutput();
        //确认客户端接受完毕，才能断开
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2=is.read(buffer2))!=-1){
            baos.write(buffer2,0,len2);
        }
        System.out.println(baos.toString());
        //关闭
        baos.close();
        is.close();
        fis.close();
        os.close();
        socket.close();
    }
}
