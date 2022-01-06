package com.lz.sort;

import java.util.*;

/**
 * 桶排序
 * @author lihao
 */
public class BucketSort {
    public static void main(String[] args) {
        double[] array = {4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static double[] bucketSort(double[] array) {
        double max = 0;
        double min = 0;
        //获得最大值和最小值之间的差
        for (double v : array) {
            if (v > max) {
                max = v;
            }
            if (v < min) {
                min = v;
            }
        }
        double d = max - min;
        //桶初始化
        int bucketNum = array.length;
        List<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }
        //将每个元素放入桶中
        for (double v : array) {
            int num = (int) ((v - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(v);
        }
        for (LinkedList<Double> doubles : bucketList) {
            Collections.sort(doubles);
        }
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }
}
