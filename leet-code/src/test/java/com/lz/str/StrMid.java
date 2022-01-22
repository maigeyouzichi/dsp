package com.lz.str;

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

}
