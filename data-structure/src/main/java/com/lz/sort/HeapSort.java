package com.lz.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 说明: 堆的本质是完全二叉树,
 * arr.length/2-1可以获取最后一个非叶子节点的index下标
 * index_parent*2+1 = index_child_left
 * index_parent*2+2 = index_child_right
 * @author lihao
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 4, 3, 5, 2, 10, 9, 8};
        System.out.println("排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    private static void sort(int[] array) {
        //1,把无序数组构建成最大堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子节点的下标开始,一直到0
            adjustHeap(array, i, array.length);
        }
        // 2. 调整堆结构+交换堆顶元素与末尾元素，调整堆产生新的堆顶
        for (int i = array.length - 1; i > 0; i--) {
            // 最后1个元素和第1个元素进行交换
            int temp = array[i];
            array[i] = array[0];
            // “下沉”调整最大堆
            array[0] = temp;
            adjustHeap(array, 0, i);
        }
    }

    private static void adjustHeap(int[] array, int parentIndex, int length) {
        //temp 保存父节点的值,用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //如果存在右孩子,且右孩子大于左孩子的值,则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            //如果父节点大于任何一个孩子的值,则直接跳出
            if (temp >= array[childIndex]) break;
            //无须真正交换,单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            //下一个左孩子
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }
}
