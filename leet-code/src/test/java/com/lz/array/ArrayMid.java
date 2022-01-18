package com.lz.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     * 15 三数之和
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0) return result;
            if (i >0 && nums[i] == nums[i-1]) continue;
            int left = i +1;
            int right = nums.length -1;
            while (left < right) {
                int sum = nums[i]+nums[left]+nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left<right && nums[left] == nums[left+1]) left ++;
                    while (right > left && nums[right] == nums[right -1]) right --;
                    left ++;
                    right --;
                }else if (sum > 0) {
                    right --;
                }else {
                    left ++;
                }
            }
        }
        return result;
    }

    /**
     * 16. 最接近的三数之和
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length -1;
            while (left < right) {
                int sum = nums[i]+nums[left]+nums[right];
                if (Math.abs(target-result)>Math.abs(target-sum)) result = sum;
                if (sum == target) return sum;
                else if (sum > target) right --;
                else left ++;
            }
        }
        return result;
    }
}
