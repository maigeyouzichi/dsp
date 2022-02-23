package com.lz.senior.atomic;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author lihao on 2022/2/23
 */
@SuppressWarnings("all")
public class LongAdderTest {

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        System.out.println(longAdder.longValue());

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                longAdder.increment();
                System.out.println(longAdder.longValue());
            }
        }).start();
        new Thread(()->{
            longAdder.increment();
            System.out.println(longAdder.longValue());
        }).start();
    }
}
