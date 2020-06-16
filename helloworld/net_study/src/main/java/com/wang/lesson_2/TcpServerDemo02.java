package com.wang.lesson_2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 服务端02
 * 文件接收
 */
public class TcpServerDemo02 {
    @lombok.SneakyThrows
    public static void main(String[] args) {
        //创建服务
        ServerSocket ss = new ServerSocket(9000);
        //监听
        Socket socket = ss.accept();//阻塞式监听，会一直等待客户端连接
        //获取输入流
        InputStream is = socket.getInputStream();
        //文件输出
        FileOutputStream fos = new FileOutputStream(new File("helloworld/net_study/receive.gif"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        //通知客户端接受完毕
        OutputStream os = socket.getOutputStream();
        os.write("我接受完毕了，你可以断开了".getBytes());
        //关闭
        os.close();
        fos.close();
        is.close();
        socket.close();
        ss.hashCode();
    }
}
