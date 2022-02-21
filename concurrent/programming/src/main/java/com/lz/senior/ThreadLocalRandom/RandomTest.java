package com.lz.senior.ThreadLocalRandom;

import java.util.Random;

/**
 * @author lihao on 2022/2/21
 * 根据当前种子获取新的种子从而获取随机数,源码中使用CAS操作,使得每个线程获取的种子不会重复,但是保证线程安全
 * 的时候需要增加开销,大量线程会进行自旋重试.这种情况下产生了ThreadLocalRandom {@link ThreadLocalRandomTest}
 */
@SuppressWarnings("all")
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }
    }
}
