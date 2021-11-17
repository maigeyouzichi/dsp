package com.lz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
@SpringBootTest
public class TwoSum {

    @Test
    public void test() {
        int[] arr = new int[]{2,7,11,15};
        int[] res = twoSum(arr, 9);
        System.out.println(Arrays.toString(res));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int another = target - a;
            Integer index = map.get(another);
            if (index != null) {
                return new int[]{index,i};
            }
            map.put(a,i);
        }
        return new int[]{};
    }
}
