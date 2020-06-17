package com.wang.chat;

public class User2 {
    public static void main(String[] args) {
        //开启两个线程
        new Thread(new TalkSend(8888,"localhost",7777)).start();
        new Thread(new TalkReceive(6666)).start();
    }
}
