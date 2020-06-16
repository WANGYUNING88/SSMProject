package com.wang.lesson_3;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 不需要连接服务器
 */
public class UDPClientDemo01 {
    @SneakyThrows
    public static void main(String[] args) {
        //建立一个socket
        DatagramSocket socket = new DatagramSocket();

        //建立数据包
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
        String msg = "你好，服务器！";
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);

        //发送包
        socket.send(datagramPacket);

        //关闭
        socket.close();
    }
}
