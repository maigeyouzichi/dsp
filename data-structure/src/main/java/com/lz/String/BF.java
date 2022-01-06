package com.lz.String;

/**
 * 暴力匹配算法
 * @author lihao
 */
public class BF {

    public static void main(String[] args) {
        String main = "hello";
        String sub = "ll";
        System.out.println(isMatch(main, sub));
    }

    private static boolean isMatch(String main, String sub) {
        int range = main.length() - sub.length();
        for (int i = 0; i <= range; i++) {
            String temp = main.substring(i,i+sub.length());
            boolean equals = temp.equals(sub);
            if (equals) return true;
        }
        return false;
    }
}
