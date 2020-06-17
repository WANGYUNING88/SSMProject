package com.wang.chat;

public class User1 {
    public static void main(String[] args) {
        //开启两个线程
        new Thread(new TalkSend(5555,"localhost",6666)).start();
        new Thread(new TalkReceive(7777)).start();
    }
}
