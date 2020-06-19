package org.example;

/**
 * 测试：生产者消费者模型 -> 信号灯法，标志位解法
 * <p>
 * 生产者；消费者；产品
 */
public class TestP_C2 {
    public static void main(String[] args) {
        Product2 product2 = new Product2();
        new Productor2(product2).start();
        new Customer2(product2).start();
    }
}

/**
 * 生产者
 */
class Productor2 extends Thread {
    Product2 product2;


    public Productor2(Product2 product2) {
        this.product2 = product2;
    }

    String[] bookNames = {
            "Effective Java 3rd Edition", "Modern Java Recipes", "Java编程规范", "Java编程思想",
            "Java核心技术：卷I基础知识", "Java数据结构和算法", "Java与模式", "SCJP学习指南",
            "重构：改善既有代码的设计", "Java消息服务"
    };
    String[] frameworks = {
            "Spring", "SpringMVC", "SpringBoot", "Mybatis", "Dubbo", "Maven", "RabbitMQ", "Log4j", "Redis", "Shiro"
    };

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.product2.product("Java基础知识《" + this.bookNames[(int) (Math.random() * this.bookNames.length)] + "》");
            } else {
                this.product2.product("Java框架知识《" + this.frameworks[(int) (Math.random() * this.frameworks.length)] + "》");
            }
        }
    }
}

/**
 * 消费者
 */
class Customer2 extends Thread {
    Product2 product2;

    public Customer2(Product2 product2) {
        this.product2 = product2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.product2.consume();//消费
        }
    }
}

/**
 * 产品
 */
class Product2 {
    //规则：
    //生产者生产时，消费者等待
    //消费者消费时，生产者等待
    String name;//产品名称
    boolean flag = true;

    //生产
    public synchronized void product(String name) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("<-生产了产品" + name);
        //通知消费者
        this.notifyAll();
        this.name = name;
        this.flag = !this.flag;
    }

    //消费
    public synchronized void consume() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("->消费了产品" + this.name);
        //通知生产者生产
        this.notifyAll();
        this.flag = !this.flag;
    }
}

