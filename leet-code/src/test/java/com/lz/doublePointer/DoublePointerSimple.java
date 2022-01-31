package com.lz.doublePointer;

/**
 * 双指针 简单
 */
public class DoublePointerSimple {

    /**
     * 1342. 将数字变成 0 的操作次数
     */
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if ((num&1)==1) {
                num -= 1;
                count += 1;
            }else {
                num = num/2;
                count ++;
            }
        }
        return count;
    }
}
