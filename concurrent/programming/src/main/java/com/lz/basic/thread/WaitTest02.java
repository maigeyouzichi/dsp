package com.lz.basic.thread;

import java.util.concurrent.TimeUnit;

/**
 * wait()方法添加时间参数构造,超时后可以自动释放锁,同时代码继续向下执行
 * @author lihao
 */
@SuppressWarnings("all")
public class WaitTest02 {

    public static void main(String[] args) {
        Object obj = new Object();

        new Thread(() -> {
            synchronized (obj) {
                System.out.println("A 获取到了锁 !");
                try {
                    obj.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A 释放了锁 !");
            }
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("B 在阻塞 !");
            synchronized (obj) {
                System.out.println("B 获取了锁!");
            }
        },"B").start();
    }
}
