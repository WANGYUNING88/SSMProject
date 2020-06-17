package com.wang.chat;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveDemo01 {
    @SneakyThrows
    public static void main(String[] args) {
        DatagramSocket socket = new DatagramSocket(6666);

        byte[] container = null;

        while (true) {
            container = new byte[1024];
            DatagramPacket datagramPacket =
                    new DatagramPacket(container, 0, container.length);

            socket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            String s = new String(data, 0, data.length);

            System.out.println("【"+datagramPacket.getAddress().getHostAddress()+"】:"
                        +s);

            if ("<bye>".equals(s.trim())) {
                break;
            }
        }
    }
}
