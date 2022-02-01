package com.lz.other;

import org.junit.jupiter.api.Test;

/**
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * @author lihao
 * @date 2021-11-17 12:56
 */
@SuppressWarnings("ALL")
public class LengthOfLongestSubstring {

    @Test
    void tese() {
    }

    /**
     * 滑动窗口
     */
    private int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)  return 0;
        int left = 0,right = 0,res = 0;
        boolean[] bitArr = new boolean[256];
        while (right < s.length()) {
            if (bitArr[s.charAt(right)]) {
                bitArr[s.charAt(left)] = false;
                left ++;
            }else {
                bitArr[s.charAt(right)] = true;
                right ++;
            }
            res = Math.max(right -left,res);
        }
        return res;
    }
}
