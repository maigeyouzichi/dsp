package com.lz.String;

/**
 * 滑动匹配算法
 *
 * @author lihao
 */
public class BM {
    public static void main(String[] args) {
        String s1 = "abcabcabc";
        String s2 = "bca";
        System.out.println(bad(s1.toCharArray(), s2.toCharArray()));
    }

    /**
     * 全局变量或成员变量
     */
    private static final int SIZE = 256;

    public static int bad(char[] a, char[] b) {
        //主串长度
        int m = a.length;
        //模式串长度
        int n = b.length;
        //创建字典
        int[] bc = new int[SIZE];
        //构建坏字符串hash表,记录模式串中每个字符最后出现的位置
        generateBC(b, n, bc);
        //i表示主串与模式串对齐的第一个字符的索引
        int i = 0;
        //可以滑动的最远距离
        while (i <= m - n) {
            int j;
            //从后往前遍历模式串
            for (j = n - 1; j >= 0; j--) {
                //如果不匹配,直接跳出循环
                if (a[i + j] != b[j]) break;
            }
            if (j < 0) {
                //如果j<0,说明没有出发break,即:匹配成功,返回模式串第一个字符在主串的位置索引
                return i;
            }
            //将模式串往后滑动
            i = i + (j - bc[(int) a[i + j]]);
        }
        return -1;
    }

    private static void generateBC(char[] b, int m, int[] dc) {
        for (int i = 0; i < SIZE; i++) {
            dc[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            //char --> ascii 数值: a=9 b=98
            int ascii = (int) b[i];
            dc[ascii] = i;
        }
    }
}
