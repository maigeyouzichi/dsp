package com.lz.array;

import com.lz.entity.ListNode;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 数组类型题目 -- 简单
 */
@SuppressWarnings("all")
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
     * 1 2 3 4 5 3 4 4 5
     * p=0 1 2
     * q=1 2 3 4 5 6 7
     * 思路: 双指针遍历数组:
     * 如果p,q位置数据相同,q++
     * 如果p,q位置数据不同,q下标数据和p+1下标数据交换,同时p++
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
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 就等于val的值交换到数组的最后,返回新数组的长度,如果i所在数字等于val,返回长度-1
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
     * 题目:给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
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
     * 题目:给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plus-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
                    swap(nums,k, k+1);
                }
            }
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
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
     * 思路:指定一个标志变量
     */
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int index = nums.length - 1;
        int count = 2;
        while (index > 0) {
            if (nums[index] != nums[index - 1]) {
                count--;
                if (count == 0) return nums[index - 1];
            }
            index--;
        }
        return nums[nums.length - 1];
    }


    /**
     * 448. 找到所有数组中消失的数字
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arr = new int[nums.length + 1];
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
            min = Math.min(min, nums[i]);
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
                count++;
                i++;
            }
            j++;
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
                    land++;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        border++;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        border++;
                    }
                }
            }
        }
        return land * 4 - border * 2;
    }

    /**
     * 485, 最大连续1的个数
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tmp++;
                result = Math.max(result, tmp);
            } else {
                tmp = 0;
            }
        }
        return result;
    }

    /**
     * 495. 提莫攻击
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int m = timeSeries[i];
            int n = timeSeries[i + 1];
            if (m + duration - 1 < n) {
                result += duration;
            } else {
                result += n - m;
            }
        }
        return result + duration;
    }

    /**
     * 496. 下一个更大元素 I
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = map.get(nums1[i]);
            result[i] = -1;
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 键盘行
     */
    public String[] findWords(String[] words) {
        return Arrays.asList(words)
                .stream()
                .filter(s->
                        s.toLowerCase().replaceAll("^[qwertyuiop]*$", "").equals("")
                                || s.toLowerCase().replaceAll("^[asdfghjkl]*$", "").equals("")
                                || s.toLowerCase().replaceAll("^[zxcvbnm]*$", "").equals("")
                )
                .collect(Collectors.toList())
                .toArray(new String[0]);
    }

    @Test
    void test() {
        int[] arr = {1,1,1,-4};
        System.out.println(singleNumber2(arr));
    }

    public int singleNumber2(int[] nums) {
        int[] arr = new int[32];
        for(int num: nums) {
            for(int i=0;i<32;i++) {
                arr[31-i] += (num>>i)&1;
            }
        }
        int rns = 0;
        for(int i=0;i<32;i++) {
            rns += (arr[i]%3)<<(31-i);
        }
        return rns;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);//为了包含index从0开始的子数组,前缀和刚好等于k的时候,count++
        int count = 0,tmpSum = 0;
        for(int nu: nums) {
            tmpSum += nu;
            if(map.containsKey(tmpSum-k)) count += map.get(tmpSum-k);
            map.put(tmpSum,map.getOrDefault(tmpSum, 0)+1);
        }
        return count;
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxLen = 0,currLen = 0;
        for(int num: nums) {
            if(map.containsKey(num)) continue;
            int left = map.getOrDefault(num-1,0);
            int right = map.getOrDefault(num+1,0);
            currLen = left+right+1;
            map.put(num,currLen);
            maxLen = Math.max(maxLen, currLen);
            map.put(num-left, currLen);
            map.put(num+right, currLen);
        }
        return maxLen;
    }

    private void testLinkedList() {
        Deque<Integer> stack = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.offer(1);
        queue1.poll();
        new LinkedList().removeFirst();
        Queue<Integer> queue2 = new ArrayDeque<>();
        Queue<Integer> queue3 = new PriorityQueue<>();
    }

    private List<String> rns = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    private boolean[] bitArr;//判断是否存在于StringBuilder中
    char[] chars;//所有元素
    int k;//初始字符串大小
    int count = 0;
    public String[] permutation(String S) {
        bitArr = new boolean[S.length()];
        k = S.length();
        chars = S.toCharArray();
        backTracing();
        return rns.toArray(new String[rns.size()]);
    }

    private void backTracing() {
        if (count == k) {
            rns.add(sb.toString());
            return;
        }
        for (int i=0;i<chars.length;i++) {
            if (bitArr[i]) continue;
            sb.append(chars[i]);
            bitArr[i] = true;
            count++;
            backTracing();
            count--;
            sb.deleteCharAt(count);
            bitArr[i] = false;
        }
    }

    public int[][] merge(int[][] intervals) {
        int[] target = new int[10000];//index = 区间第一个元素,value= 原数组索引
        int[] sortedArr = new int[intervals.length];
        for(int i=0;i<intervals.length;i++) {
            if(i>0 && intervals[target[intervals[i][0]]][0]== intervals[i][0] && intervals[target[intervals[i][0]]][1] == intervals[i][1]) continue;
            target[intervals[i][0]] = i;
            sortedArr[i] = intervals[i][0];
        }
        Arrays.sort(sortedArr);
        int first = 0, second = 1;
        List<int[]> tmpList = new ArrayList<>();
        while(first < sortedArr.length) {
            int firstValueLeft = intervals[target[sortedArr[first]]][0];
            int firstValueRight = intervals[target[sortedArr[first]]][1];
            if(second >= sortedArr.length) {
                tmpList.add(new int[]{firstValueLeft,firstValueRight});
                break;
            }
            int secondValueLeft = intervals[target[sortedArr[second]]][0];
            int secondValueRight = intervals[target[sortedArr[second]]][1];
            if(firstValueRight >= secondValueLeft) {
                intervals[target[sortedArr[first]]][1] = Math.max(firstValueRight,secondValueRight);
                second ++;
            }else {
                tmpList.add(new int[]{firstValueLeft,firstValueRight});
                first = second;
                second = first + 1;
            }
        }
        return tmpList.toArray(new int[tmpList.size()][]);
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        boolean[] bitArr = new boolean[201];
        ListNode virtualNode = new ListNode();
        ListNode pre = virtualNode;
        ListNode curr = head;
        while(curr != null) {
            if(!bitArr[curr.val+100] && (curr.next == null || curr.val != curr.next.val)) {
                pre.next = curr;
                pre = pre.next;
            }
            bitArr[curr.val+100] = true;
            curr = curr.next;
        }
        return virtualNode.next;
    }

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        Long[] arr = {2L,3L,5L};
        pq.offer(1L);
        int count = 0;
        while(!pq.isEmpty()) {
            Long curr = pq.poll();
            count ++;
            if(count == n) return Math.toIntExact(curr);
            for(Long num: arr) {
                Long tmp = curr*num;
                if(set.add(tmp)) pq.offer(tmp);
            }
        }
        return 0;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] rns = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]) {
                int currIndex = stack.pop();
                rns[currIndex] = i-currIndex;
            }
            stack.push(temperatures[i]);
        }
        return rns;
    }

    public String predictPartyVictory(String senate) {
        int len = senate.length();
        char[] charArray = senate.toCharArray();
        LinkedList<Integer> queue_D = new LinkedList<>();
        LinkedList<Integer> queue_R = new LinkedList<>();
        for (int i=0;i<len;i++) {
            if (charArray[i] == 'D') {queue_D.offer(i);} else {queue_R.offer(i);}
        }
        while (!queue_R.isEmpty() || !queue_D.isEmpty()) {
            if (queue_R.isEmpty()) return "Dire";
            if (queue_D.isEmpty()) return "Radiant";
            if (queue_D.peek()<queue_R.peek()) {
                queue_D.offer(queue_D.poll()+len);
                queue_R.poll();
            }
            if (queue_D.peek()>queue_R.peek()) {
                queue_R.offer(queue_R.poll()+len);
                queue_D.poll();
            }
        }
        return "";
    }
}
