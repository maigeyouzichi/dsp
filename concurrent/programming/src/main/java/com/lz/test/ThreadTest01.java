package com.lz.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 线程三种启动方式
 * @author lihao
 */
@SuppressWarnings("all")
public class ThreadTest01 {

    /**
     * 启动线程方式一: 继承Thread类,重写run()方法
     */
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("i am a child thead !");
        }
    }

    /**
     * 启动线程方式二: 实现runnable接口,重写run()方法
     */
    public static class RunnableTask implements Runnable{
        @Override
        public void run() {
            System.out.println("i am a child thread !");
        }
    }

    /**
     * 启动线程方式三: 实现Callble接口,重写call()方法
     */
    public static class CallerTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Hello World";
        }
    }

    public static void main(String[] args) {
        //创建线程
        //MyThread thread = new MyThread();
        //启动线程
        //thread.start();

//        RunnableTask task = new RunnableTask();
//        new Thread(task).start();
//        new Thread(task).start();

        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();
        try {
            //等待任务执行完毕,并返回结果
            String resut = futureTask.get();
            System.out.println(resut);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
