package com.wang.chat;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TalkReceive implements Runnable {
    DatagramSocket socket = null;
    private int port;

    @SneakyThrows
    public TalkReceive(int port) {
        this.port = port;
        socket = new DatagramSocket(port);
    }

    @SneakyThrows
    @Override
    public void run() {
        byte[] container = null;
        while (true) {
            container = new byte[1024];
            DatagramPacket datagramPacket =
                    new DatagramPacket(container, 0, container.length);

            socket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            String s = new String(data, 0, data.length);

            System.out.println("【"+datagramPacket.getAddress().getHostAddress()+
                    ":"+this.port+"】:"
                    +s);

            if ("<bye>".equals(s.trim())) {
                break;
            }
        }
        socket.close();
    }
}
