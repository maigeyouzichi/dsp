package com.lz.dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode上的动态规划
 * @author lihao
 * @date 2021-11-24 14:21
 */
public class DpOnLeetCode {

    /**
     * 难度:简单  ----------------------------------------------------
     */

    /**
     * 53. 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 理解:
     * dp[i]表示以第i个数结尾的连续数组最大和,我们需要求出最大的dp[i]
     * 这个题目不是很符合一般的动态规划的套路,没有使用数据存储中间值,不是常规思维
     * 从左向右遍历,左索引为0,右索引为i,这段数值相加为正数就保留,为负数直接全部舍弃.会出现新的左索引.
     *
     * 真的难,感觉已经是思维极限了. ORZ ...
     */
    int function001(int[] nums) {
        if (nums.length ==0) return 0;
        int pre = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre+nums[i],nums[i]);
            result = Math.max(pre,result);
        }
        return result;
    }

    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     * 思路: dp[n]表示n阶楼梯可以选择的爬楼方式
     * dp[i] = dp[i-1] + dp[i-2]
     */
    int function002(int n) {
        if (n==1 || n==2 || n==3) {return n;}
        int[] dp = new int[n + 1];
        for (int i = 1; i < 4; i++) {
            dp[i] = i;
        }
        for (int i = 4; i < n + 1; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    @Test
    void test001 () {
        System.out.println(generate(5));
    }
    /**
     * 118. 杨辉三角
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     * 提示:
     * 1 <= numRows <= 30
     * 思路: 需要一个二维数组,长度为行数,非负数记录入数组
     */
    List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0 || j==i) {
                    tmp.add(1);
                } else {
                    tmp.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(tmp);
        }
        return result;
    }

    /**
     * 杨辉三角2
     * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     * 思路: 这个题区别于上题,上题需要保存集合中全部数据,该题目只需要集合的最后一个元素集合
     */
    List<Integer> getRow(int rowIndex) {
        //储存最终结果
        List<Integer> result = new ArrayList<>();
        //初始值
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }
        //储存中间结果
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j==0 || i==j) {
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
                if (i == rowIndex) {
                    result.add(dp[i][j]);
                }
            }
        }
        return result;
    }



}
