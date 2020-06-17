package com.wang.chat;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TalkSend implements Runnable {

    DatagramSocket socket = null;
    BufferedReader reader = null;



    private String toIP;
    private int toPort,fromPort;

    @SneakyThrows
    public TalkSend(int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;
        socket = new DatagramSocket(fromPort);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            DatagramPacket datagramPacket =
                    new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIP, this.toPort));
            socket.send(datagramPacket);
            if ("<bye>".equals(data))
                break;
        }

        socket.close();
    }
}
