package com.lz.basic.thread;

/**
 * @author lihao on 2022/2/20
 * 子线程可以获取父线程中的变量
 * 应用场景: 子线程获取父线程的用户登录等信息
 */
@SuppressWarnings("all")
public class InheritableThreadLocalTest {

    //static ThreadLocal<String> localVariable = new ThreadLocal<>();
    static ThreadLocal<String> localVariable = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        localVariable.set("hello world");

        new Thread(() ->{System.out.println("子线程获取父线程变量:"+localVariable.get());}).start();
        System.out.println("主线程获取变量:"+localVariable.get());
    }
}
