package com.lz.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
            if (index != 0) return new int[]{i, index};
            map.put(ele, i);
        }
        return null;
    }

    /**
     * 26. 删除有序数组中的重复项
     * <p>
     * 1 2 3 4 3 3 3 4
     * p=0 1 2
     * q=1 2 3 4 5 6 7
     * 思路: 双指针遍历数组:
     * 如果p,q位置数据相同,q++
     * 如果p,q位置数据不同,q下标数据和p+1下标数据交换,同时
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] == nums[q]) {
                q++;
            } else {
                nums[p + 1] = nums[q];
                p++;
            }
        }
        return p + 1;
    }

    /**
     * 27,移除元素
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] == val) {
                int tmp;
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j--;
            } else {
                i++;
            }
        }
        if (nums[i] == val) return i;
        return i + 1;
    }

    /**
     * 35. 搜索插入位置
     */
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (nums[i] < target) {
            return i + 1;
        } else {
            return i;
        }
    }

    /**
     * 66,加一
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            digits[i] = digits[i] % 10;
            //如果不需要进位,直接返回
            if (digits[i] != 0) return digits;
        }
        //如果可以走到这一步,说明一直都在进位,即9999这样的情况
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    /**
     * 88,合并有序数组
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int k = nums1.length - 1;
        while (n >= 0) {
            if (m >= 0 && nums1[m] > nums2[n]) {
                nums1[k] = nums1[m];
                m--;
            } else {
                nums1[k] = nums2[n];
                n--;
            }
            k--;
        }
    }

    /**
     * 136. 只出现一次的数字
     * 位运算:
     * &: 与 -- 1 & 1 = 1 其余都是0
     * |: 或 -- 存在1就是1
     * ^: 异或 -- 相同为0,不同为1 即: 任何数字和0进行异或运算结果都是数字本身, 任何数字和其本身异或结果都是0,且支持交换律.
     */
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }

    /**
     * 167.两数之和 有序数组
     */
    private int[] twoSum02(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int sum;
        while (i < j) {
            sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    /**
     * 169,多数元素
     */
    public int majorityElement(int[] nums) {
        int t = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.get(num) == null ? 0 : map.get(num);
            count++;
            if (count > t) return num;
            map.put(num, count);
        }
        return 0;
    }

    /**
     * 217,存在重复元素
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.get(num) != null) return true;
            map.put(num, 1);
        }
        return false;
    }

    /**
     * 217,存在重复元素
     * 优化
     */
    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }

    /**
     * 219.存在重复元素2
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && Math.abs(i - index) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * 228.汇总区间
     * 注意: 数字类型溢出
     * a - b > 1 写成 a - 1 > b
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        if (nums.length == 1) {
            list.add(nums[0] + "");
            return list;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[j] - 1 > nums[j - 1] && j - i > 1) {
                String str = nums[i] + "->" + nums[j - 1];
                list.add(str);
                i = j;
            } else if (nums[j] - 1 > nums[j - 1] && j - i == 1) {
                list.add(nums[i] + "");
                i = j;
            }
            j++;
        }
        if (nums[j - 1] - 1 == nums[j - 2]) {
            String str = nums[i] + "->" + nums[j - 1];
            list.add(str);
        } else {
            list.add(nums[i] + "");
        }
        return list;
    }

    /**
     * 268.丢失的数字
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

    /**
     * 268.丢失的数字 优化
     * 思路: 位运算--异或, 0和任何数运算,结果都是数本身,两个相同的数进行异或运算,结果为0
     */
    public int missingNumber2(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i < nums.length + 1; i++) {
            xor ^= i;
        }
        return xor;
    }

    /**
     * 283. 移动零
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) return;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                int j = i;
                while (nums[j] != 0) {
                    j--;
                    if (j < 0) return;
                }
                for (int k = j; k < i; k++) {
                    int tmp = nums[k];
                    nums[k] = nums[k + 1];
                    nums[k + 1] = tmp;
                }
            }
        }
    }

    /**
     * 283. 移动零 优化
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int i = 0;
        while (true) {
            while (nums[i]!=0) {
                i++;
                if (i >= nums.length) return;
            }
            int j = i;
            while (nums[j] == 0) {
                j ++;
                if (j >= nums.length) return;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
        }
    }

    /**
     * 283. 移动零 再次优化
     * 思路: 直接覆盖,最后将后面的数置为零
     */
    public void moveZeroes3(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
            j ++;
        }
        for (int k = i; k < nums.length; k++) {
            nums[k] = 0;
        }
    }


    @Test
    void test() {
        int[] nums = {0,1,0,3,12};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

}
