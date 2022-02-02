package com.lz.bitOperation;

import org.junit.jupiter.api.Test;

/**
 * 位运算
 */
@SuppressWarnings("all")
public class BitOperation {

    /**
     * 231. 2 的幂
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count ++;
                if (count > 1) return false;
            }
            n = n >> 1;
        }
        return true;
    }

    @Test
    void test() {
        System.out.println(1 >> 1);
    }
}
