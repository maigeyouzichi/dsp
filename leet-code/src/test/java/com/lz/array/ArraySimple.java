package com.lz.array;

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


}
