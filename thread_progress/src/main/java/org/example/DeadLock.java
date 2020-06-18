package org.example;

/**
 * 死锁问题
 */
public class DeadLock {
    public static void main(String[] args) {

        new Play("张三",0).start();
        new Play("李四",1).start();
    }
}


class Computer{

}
class Game{

}
class Play extends Thread{
    //使用static 来保证只有一份资源
    static Computer computer= new Computer();
    static Game game= new Game();

    int choice;//选则
    String name;//人

    Play(String name,int choice){
        this.name = name;
        this.choice = choice;
    }

    @Override
    public void run() {
        //玩游戏
        try {
//            playGame();
            playGame1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 死锁
     * @throws InterruptedException
     */
    private void playGame() throws InterruptedException {
        if (this.choice==0){
            synchronized (computer){
                //获取到电脑的 锁
                System.out.println(this.name+"获得【电脑】的锁");
                Thread.sleep(1000);
                synchronized (game){
                    //1秒后想获得游戏 的锁
                    System.out.println(this.name+"获得【游戏】的锁");
                }
            }
        }else {
            synchronized (game){
                //获取到游戏的 锁
                System.out.println(this.name+"获得【游戏】的锁");
                Thread.sleep(1000);
                synchronized (computer){
                    //1秒后想获得电脑 的锁
                    System.out.println(this.name+"获得【电脑】的锁");
                }
            }
        }
    }

    /**
     * 不会死锁
     * @throws InterruptedException
     */
    private void playGame1() throws InterruptedException {
        if (this.choice==0){
            synchronized (computer){
                //获取到电脑的 锁
                System.out.println(this.name+"获得【电脑】的锁");
                Thread.sleep(1000);
            }
            synchronized (game){
                //1秒后想获得游戏 的锁
                System.out.println(this.name+"获得【游戏】的锁");
            }
        }else {
            synchronized (game){
                //获取到游戏的 锁
                System.out.println(this.name+"获得【游戏】的锁");
                Thread.sleep(1000);
            }
            synchronized (computer){
                //1秒后想获得电脑 的锁
                System.out.println(this.name+"获得【电脑】的锁");
            }
        }
    }
}