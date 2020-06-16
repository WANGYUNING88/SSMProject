package com.wang.lesson_2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端01
 */
public class TcpClientDemo01 {

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //1.要知道服务器的地址
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            //端口号
            int port = 9999;
            //2.创建一个socket连接
            socket = new Socket(serverIp,port);
            //3. 发送消息 io流
            outputStream = socket.getOutputStream();
            outputStream.write("你好，欢迎".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream!=null){
                    outputStream.close();
                }
                if (socket!=null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
