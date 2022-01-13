package com.lz.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组类型题目 -- 简单
 */
public class ArraySimple {

    /**
     * 1. 两数之和
     */
    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            int t = target - ele;
            Integer index = map.get(t);
            if (index != 0) return new int[]{i,index};
            map.put(ele, i);
        }
        return null;
    }

    /**
     * 26. 删除有序数组中的重复项
     *
     * 1 2 3 4 3 3 3 4
     * p=0 1 2
     * q=1 2 3 4 5 6 7
     * 思路: 双指针遍历数组:
     *  如果p,q位置数据相同,q++
     *  如果p,q位置数据不同,q下标数据和p+1下标数据交换,同时
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p]==nums[q]) {
                q++;
            }else {
                nums[p+1] = nums[q];
                p++;
            }
        }
        return p+1;
    }




}
