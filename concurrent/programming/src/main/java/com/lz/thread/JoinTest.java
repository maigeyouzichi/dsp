package com.lz.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author lihao
 * join()测试
 * 当前线程调用其他线程的join方法,表示当前线程让出cpu资源给到刚刚调用的线程,待调用线程执行完毕后再继续往下执行自身代码
 */
@SuppressWarnings("all")
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            System.out.println("A线程获取锁");
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("A线程释放锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A");

        Thread threadB = new Thread(() -> {
            System.out.println("B线程获取锁");
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("B线程释放锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B");

        System.out.println(" A B is beginning ...");
        threadA.start();
        threadB.start();
        //threadA.join();
        threadB.join();
        System.out.println(" A B is over !");
    }
}
