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
        int j = function004("hello","kitty");
        System.out.println(j);
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
     * 规律:dp[m-1][n-1] = dp[m-1-1][n-1] + dp[m-1][n-1-1]
     */
    int function002(int m ,int n) {
        if (m <1 || n<1 ) {return 0;}
        if (m==1 || n==1) {return 1;}
        //结果数组
        int[][] dp = new int[m][n];
        //初始值
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 机器人移动格子, 路径格子数相加最小值
     * m x n 的格子方阵
     * dp[m-1][n-1]表示从dp[0][0](即左上角)移动到m行n列位置(即dp[m-1][n-1])
     * dp[i][j] = min(dp[i][j-1],dp[i-1][j])+arr[i][j]
     */
    int function003(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        if (m<=0 || n<=0 ) { return 0; }
        //用来存储每一个计算的值
        int[][] dp = new int[m][n];
        //初始值
        dp[0][0] = arr[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }
        //规律
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + arr[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 编辑距离: wordA -> wordB 需要的最少步骤
     * dp[i][j]:长度为i字符串转换为长度为j的字符串需要的最少步骤
     *
     * 总结下目前的解题思路:
     * 1, 定义dp[i][j]的含义
     * 2, 确定存储中间数据的数组,大部分是二维数组
     * 3, 确定初始值
     * 4, 确定i=0 或者 j=0 时的边界数据
     * 5, 找出dp[i][j]与dp[i-1][j-1],dp[i-1][j],dp[i][j-1]的关系
     */
    int function004(String wordA,String wordB) {
        int i = wordA.length();
        int j = wordB.length();
        if (i==0 || j==0) {return i+j;}
        int[][] dp = new int[i+1][j+1];
        for (int k = 1; k <= i; k++) {
            dp[k][0] = k;
        }
        for (int k = 1; k <= j; k++) {
            dp[0][k] = k;
        }
        for (int k = 1; k <= i; k++) {
            for (int l = 1; l <= j; l++) {
                if (wordA.charAt(k-1) == wordB.charAt(l-1)) {
                    dp[k][l] = dp[k-1][l-1];
                }else {
                    dp[k][l] = Math.min(Math.min(dp[k-1][l],dp[k][l-1]),dp[k-1][l-1])+1;
                }
            }
        }
        return dp[i][j];
    }
}
