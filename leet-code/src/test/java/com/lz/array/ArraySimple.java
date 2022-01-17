package com.lz.array;

import org.junit.jupiter.api.Test;

import java.security.interfaces.RSAKey;
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
            while (nums[i] != 0) {
                i++;
                if (i >= nums.length) return;
            }
            int j = i;
            while (nums[j] == 0) {
                j++;
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
            j++;
        }
        for (int k = i; k < nums.length; k++) {
            nums[k] = 0;
        }
    }

    /**
     * 349. 两个数组的交集
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) set2.add(num);
        }
        int[] arr = new int[set2.size()];
        int index = 0;
        for (Integer num : set2) {
            arr[index++] = num;
        }
        return arr;
    }

    /**
     * 350,两个数交集2
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            Integer count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] arr = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                arr[index++] = num;
                map.put(num, count - 1);
            }
        }
        return Arrays.copyOfRange(arr, 0, index);
    }

    /**
     * 414,第三大的数
     */
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int index = nums.length - 1;
        int count = 2;
        while (index > 0) {
            if (nums[index] != nums[index - 1]) {
                count --;
                if (count==0) return nums[index-1];
            }
            index --;
        }
        return nums[nums.length-1];
    }


    /**
     * 448. 找到所有数组中消失的数字
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arr = new int[nums.length+1];
        for (int num : nums) {
            arr[num] = 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 453. 最小操作次数使数组元素相等
     * 思路: n-1个数字+1的效果 == 1个数字-1
     */
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min,nums[i]);
        }
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }

    /**
     * 455,分发饼干
     */
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < s.length && i < g.length) {
            if (s[j] >= g[i]) {
                count ++;
                i ++;
            }
            j ++;
        }
        return count;
    }

    /**
     * 463. 岛屿的周长
     * 思路: 这是一个数学题,找到土地个数和接壤个数即可求出值
     */
    public int islandPerimeter(int[][] grid) {
        int land = 0;
        int border = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    land ++;
                    if (i-1>=0 && grid[i-1][j] ==1) {
                        border ++;
                    }
                    if (j-1>=0 && grid[i][j-1] ==1) {
                        border ++;
                    }
                }
            }
        }
        return land * 4 -border *2;
    }

    /**
     * 485, 最大连续1的个数
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tmp ++;
                result = Math.max(result,tmp);
            }else {
                tmp = 0;
            }
        }
        return result;
    }

    @Test
    void test() {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.getOrDefault(1, 1));
    }

}
