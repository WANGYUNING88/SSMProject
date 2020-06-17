package com.wang.chat;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class UDPSenderDemo01 {
    @SneakyThrows
    public static void main(String[] args) {
        DatagramSocket socket = new DatagramSocket(8888);
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            DatagramPacket datagramPacket =
                    new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
            socket.send(datagramPacket);
            if ("<bye>".equals(data))
                break;
        }

        socket.close();
    }
}
