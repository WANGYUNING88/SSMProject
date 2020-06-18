package org.example;

/**
 * 测试：生产者消费者模型 -> 利用缓冲区解决：管程法
 * <p>
 * 生产者；消费者；产品；池子
 */
public class TestP_C {
    public static void main(String[] args) {
        SynPool synPool = new SynPool();

        new Productor(synPool).start();
        new Customer(synPool).start();

    }
}

/**
 * 生产者
 */
class Productor extends Thread {
    SynPool synPool;

    public Productor(SynPool synPool) {
        this.synPool = synPool;
    }

    @Override
    public void run() {
        //生产
        for (int i=0;i<100;i++){
            synPool.push(new Product(i));
        }
    }
}

/**
 * 消费者
 */
class Customer extends Thread {
    SynPool synPool;

    public Customer(SynPool synPool) {
        this.synPool = synPool;
    }

    @Override
    public void run() {
        //消费
        for (int i=0;i<100;i++){
            synPool.pop();
        }
    }
}

/**
 * 产品
 */
class Product {
    int id;//编号

    public Product(int id) {
        this.id = id;
    }
}

/**
 * 池子;缓冲区
 */
class SynPool {

    Product[] products = new Product[10];//定义容器大小

    int count = 0;//默认容器计数器

    /**
     * 生产者放入产品
     *
     * @param product 生产出来的产品
     */
    public synchronized void push(Product product) {
        //如果容器满了，就需要等待消费者消费
        if (count == products.length) {
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //如果没有满，我们就需要丢入产品
        products[count++] = product;
        System.out.println("加入了编号为" + product.id + "的产品");
        //可以通知消费者消费了
        this.notifyAll();
    }

    /**
     * 消费者消费
     */
    public synchronized void pop() {
        //判断消费者是否能消费，即容器中又没有产品
        if (count == 0) {
            //等到生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //如果可以消费；
        System.out.println("取出了编号为" + products[--count].id + "的产品");

        //消费完了，通知生产者生产
        this.notifyAll();
    }
}
