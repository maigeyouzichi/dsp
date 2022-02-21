package com.lz.senior.ThreadLocalRandom;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author lihao on 2022/2/21
 */
@SuppressWarnings("all")
public class ThreadLocalRandomTest {
    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }
    }
}
