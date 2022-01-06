package com.lz.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author lihao
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4,7,3,5,6,2,8,1};
        quickSort01(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 双边循环 ---------------------------------------------------------------------
     */
    private static void quickSort01(int[] arr,int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;
        //得到基准元素索引
        int pivotIndex = partition(arr,startIndex,endIndex);
        //根据基准元素,分成两部分进行递归排序
        quickSort01(arr,startIndex,pivotIndex-1);
        quickSort01(arr,pivotIndex+1, endIndex);
    }

    /**
     * 根据基准元素分边后返回基准元素索引,作为递归的条件
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left < right) {
            //这里应该先处理right,比如:2,3,5三个数字,4为基准元素,如果先处理left,基准元素会和5交换.
            while (left < right && arr[right] > pivot) right --;
            while (left < right && arr[left] <= pivot) left ++;
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }


    /**
     * 单边循环 ---------------------------------------------------------------------
     */

}
