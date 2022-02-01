package com.lz.dailyTopic;

import org.junit.jupiter.api.Test;


/**
 * 每日一题
 * @author lihao
 */
@SuppressWarnings("all")
public class Topic {

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

    /**
     * 1763. 最长的美好子字符串
     * 📌不会做 !!!
     */
    public String longestNiceSubstring(String s) {
        char[] chars = s.toCharArray();
        return "";
    }

    @Test
    void test() {
        System.out.println('a'-'A');
        System.out.println('b'-'B');
        System.out.println('n'-'N');
    }
}
