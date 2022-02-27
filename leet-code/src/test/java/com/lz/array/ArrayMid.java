package com.lz.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 算法 -- 数组
 */
@SuppressWarnings("all")
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
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     *
     * 返回这三个数的和。
     *
     * 假定每组输入只存在恰好一个解。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

    /**
     * 2134. 最少交换次数来组合所有的 1 II
     * 思路: 滑动窗口,1的个数作为窗口的长度
     */
    public int minSwaps(int[] nums) {
        int left=0,right=0,len=nums.length,count = 0,result = Integer.MAX_VALUE;
        //1的个数
        for (int num : nums) {
            count+=num;
        }
        int count2 = 0;
        while (right<count-1) {
            count2+=nums[right++];
        }
        while (left < len) {
            count2 += nums[right%len];
            result = Math.min(result,count-count2);
            right ++;
            count2 -= nums[left++];
        }
        return result;
    }


    @Test
    void test() {
        int[] arr = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
