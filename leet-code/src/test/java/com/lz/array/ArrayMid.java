package com.lz.array;

/**
 * 算法 -- 数组
 */
public class ArrayMid {

    /**
     * 11,盛水最多的容器
     * 思路: 两边高度不一,移动高点没有意义,容量取决于低点,所以移动低点,result永远记录最大值.
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int result = 0;
        while (left < right) {
            result = height[left] > height[right] ?
                    Math.max(result, (right - left) * height[right--]) :
                    Math.max(result, (right - left) * height[left++]);
        }
        return result;
    }
}
