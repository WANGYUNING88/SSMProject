package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadNew {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new MyThread1().start();;
        new Thread(new MyThread2()).start();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread3());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}

class MyThread1 extends Thread{

    @Override
    public void run() {
        System.out.println("MyThread1执行了");
    }
}

class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("MyThread2执行了");
    }
}

class MyThread3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("MyThread3执行了");
        return 7;
    }
}
