package com.wang.lesson_2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class TcpServerDemo01 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        //1,我要有一个地址
        try {
            serverSocket = new ServerSocket(9999);
            while (true) {
                //2.等待客户端链接过来
                socket = serverSocket.accept();
                //3.读取客户端的消息
                inputStream = socket.getInputStream();
                //管道流
                baos = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int len;
                while ((len = inputStream.read(bytes)) != -1) {
                    baos.write(bytes, 0, len);
                }
                System.out.println(baos.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (baos!=null)
                    baos.close();
                if (inputStream!=null)
                    inputStream.close();
                if (socket!=null)
                    socket.close();
                if (serverSocket!=null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
