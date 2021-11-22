package com.lz.dynamicProgramming;

import org.junit.jupiter.api.Test;

/**
 * 测试动态规划
 * @author lihao
 * @date 2021-11-20 16:56
 */
@SuppressWarnings("all")
public class TestDp {

    @Test
    void test() {
        int i = function001(1);
        System.out.println(i);
    }

    /**
     * 青蛙跳台阶
     * 一次可以跳一级或者两级
     * n级台阶一共有多少种跳法
     */
    int function001(int n){
        if (n < 0) {return 0;}
        if (n < 3) {return n;}
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


    /**
     * 机器人移动格子
     * m x n 的格子方阵
     * 机器人每次从最左上角开始移动, 每次可以选择向右或者向下移动一格
     * 机器人移动到最右下角一共有多少种移动的方式
     */
    int function(int m ,int n) {

        return 1;
    }
}
