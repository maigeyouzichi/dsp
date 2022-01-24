package com.lz.str;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 字符串-中等
 */
public class StrMid {

    /**
     * 3,无重复最长子串
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0;
        int right = 0;
        int res = 0;
        boolean[] bitArr = new boolean[256];
        while (right < s.length()) {
            if (bitArr[s.charAt(right)]) {
                bitArr[s.charAt(left)] = false;
                left ++;
            }else {
                bitArr[s.charAt(right)] = true;
                right ++;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }

    /**
     * 5. 最长回文子串
     * tips: 字符串先转成数组查找会更快些
     */
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int startIndex = 0;
        int maxLen = 1;
        char[] chars = s.toCharArray();
        //长度为1或者2的情况
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i<s.length()-1 && chars[i] == chars[i+1]) {
               dp[i][i+1] = true;
               startIndex = i;
               maxLen = 2;
            }
        }
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i < s.length()-len+1; i++) {
                int j = i+len-1;
                if (chars[i] == chars[j] && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    if (len > maxLen){
                        maxLen = len;
                        startIndex = i;
                    }
                }
            }
        }
        return s.substring(startIndex,startIndex+maxLen);
    }

    @Test
    public void test() {
        HashMap<Integer, Integer> map = new HashMap<>(2);
        System.out.println(map.put(0, 0));
        System.out.println(map.put(0, 1));
    }

}
