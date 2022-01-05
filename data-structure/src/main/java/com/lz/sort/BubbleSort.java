package com.lz.sort;

import java.util.Arrays;

/**
 * 冒泡算法
 * @author lihao
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5,8,6,3,9,2,1,7};
        int[] result = bubbleSort02(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序--基础版
     * @return int[]
     */
    private static int[] bubbleSort01(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                int tmp = 0;
                if (arr[j] > arr[j+1]) {
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    /**
     * 冒泡排序--优化版
     * 思路: 1,外层优化: 如果某一次内层循环中没有发生交换,说明已经排好序了,程序提前返回.
     *      2,内层优化: 每一次遍历都会把最大值放到最后,已经处理过的数据不需要再进行比较了.
     * @return int[]
     */
    private static int[] bubbleSort02(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length-1-i; j++) {
                int tmp = 0;
                if (arr[j] > arr[j+1]) {
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    isSort = false;
                }
            }
            if (isSort) return arr;
        }
        return arr;
    }
}
