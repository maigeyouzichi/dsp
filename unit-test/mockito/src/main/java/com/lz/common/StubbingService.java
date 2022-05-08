package com.lz.common;

/**
 * @author lihao on 2022/3/26
 */
public class StubbingService {

    public int getI() {
        System.out.println("============ getI ======");
        return 10;
    }

    public String getS() {
        System.out.println("=========== getS ======");
        throw new RuntimeException();
    }
}
