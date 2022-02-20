package com.lz.thread;

/**
 * 线程虚假唤醒
 * 本质就是唤醒的线程不符合唤醒的条件,缺少后续的判断使线程继续执行,造成最终的结果不正确.
 * 解决方式: 唤醒后的线程追加判断,不符合条件继续wait(),本例中使用while()代替if(),notifyAll替代notify是为了避免死锁
 * @author lihao
 */
@SuppressWarnings("all")
public class WaitTest01 {


    public static void main(String[] args) {
        Data data = new Data();
        //生产者线程A
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        //生产者线程B
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        //消费者线程C
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        //消费者线程D
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }


    /**
     * 数据类
     */
    static class Data {
        //表示数据个数
        private int number = 0;

        public synchronized void increment() throws InterruptedException {
            //if (number != 0) {
            while (number != 0) {
                this.wait();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "生产了数据:" + number);
            //this.notify();
            this.notifyAll();
        }

        public synchronized void decrement() throws InterruptedException {
            //if (number == 0) {
            while (number == 0) {
                this.wait();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "消费了数据:" + number);
            //this.notify();
            this.notifyAll();
        }
    }
}