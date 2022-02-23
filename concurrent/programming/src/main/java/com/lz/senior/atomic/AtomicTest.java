package com.lz.senior.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lihao on 2022/2/23
 */
@SuppressWarnings("all")
public class AtomicTest {

    public static void main(String[] args) {
        final AtomicLong atomicLong = new AtomicLong(1);
        System.out.println(atomicLong.get());
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(atomicLong.addAndGet(10));
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(atomicLong.addAndGet(10));
            }
        }).start();
    }
}
