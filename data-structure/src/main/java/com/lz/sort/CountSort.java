package com.lz.sort;

import java.util.Arrays;

/**
 * 计数排序 -- 适合区间不大的数据排序
 * @author lihao
 */
public class CountSort {
    public static void main(String[] args) {
        int[] target = {95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        int[] arr = countSort(target,90);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] countSort(int[] target, int offset) {
        int[] temp = new int[target.length];
        for (int i = 0; i < target.length; i++) {
            temp[target[i]-offset] ++;
        }
        int[] arr = new int[target.length];
        for (int i = 0,k=0; i < temp.length; i++) {
            if (temp[i] > 0) {
                for (int j = 0; j < temp[i]; j++) {
                    arr[k++] = i+offset;
                }
            }
        }
        return arr;
    }
}
