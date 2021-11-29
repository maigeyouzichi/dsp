package com.lz.dynamicProgramming;

import org.junit.jupiter.api.Test;

/**
 * 动态规划,中等题目
 *
 * @author lihao
 * @date 2021-11-29 10:41
 */
public class DynamicProgrammingMid {

    /**
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 思路: dp[i][j]表示索引i到j的子串是否为回文串,dp[i][j]为回文串的条件是dp[i+1][j-1]=true && str[i]=str[j],别的情况全部是false
     * 注: 需要考虑长度.
     */
    String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        int max = 1;
        int indexStart = 0;
        //长度为1的子串
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i<s.length()-1 && chars[i]==chars[i+1]) {
                dp[i][i+1] = true;
                max = 2;
                indexStart = i;
            }
        }
        //长度大于2的子串
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + len - 1;
                if (j >= s.length()) break;
                if (chars[i] == chars[j] && dp[i + 1][j - 1]) {//对于长度为2的情况并不适用
                    dp[i][j] = true;
                    if ((len > max)) {
                        max = len;
                        indexStart = i;
                    }
                }
            }
        }
        return s.substring(indexStart, indexStart + max);
    }

    @Test
    public void test() {

        String aaaaa = longestPalindrome("aaaaa");
        System.out.println(aaaaa);
    }

}
