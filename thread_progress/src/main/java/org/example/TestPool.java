package org.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * 测试线程池
 */
public class TestPool {
    public static void main(String[] args) {
        //1.创建服务，创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);//线程池大小
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //关闭连接
        service.shutdown();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
