package com.lz.String;

/**
 * 字符串hash值匹配算法
 *
 * @author lihao
 */
@SuppressWarnings("all")
public class RK {

    public static void main(String[] args) {
        String main = "hello";
        String sub = "el";
        System.out.println(isMatch(main, sub));
    }

    /**
     * 在BF暴力模式的基础上优化:
     * 将equals方法换成hash值匹配
     */
    private static boolean isMatch(String main, String sub) {
        int range = main.length() - sub.length();
        for (int i = 0; i <= range; i++) {
            String temp = main.substring(i, i + sub.length());
            boolean equals = strToHash(temp) == strToHash(sub);
            if (equals) return true;
        }
        return false;
    }

    /*** 支持 a-z 二十六进制 * 获得字符串的hash值 * @param src * @return */
    public static int strToHash(String src) {
        int hash = 0;
        for (int i = 0; i < src.length(); i++) {
            hash *= 26;
            hash += src.charAt(i) - 97;
        }
        return hash;
    }
}
