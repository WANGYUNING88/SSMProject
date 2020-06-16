package com.wang.lesson_3;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 还是要等待客户端的连接
 */
public class UDPServerDemo01 {
    @SneakyThrows
    public static void main(String[] args) {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //接受数据包
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);

        socket.receive(packet);//阻塞接收

        System.out.println("对方的地址：【"+packet.getAddress().getHostAddress()+"】");
        System.out.println("数据："+new String(packet.getData(),0,packet.getLength()));
        //关闭
        socket.close();
    }
}
