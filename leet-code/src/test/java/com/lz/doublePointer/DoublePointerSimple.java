package com.lz.doublePointer;

import com.lz.entity.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 双指针 简单
 */
@SuppressWarnings("all")
public class DoublePointerSimple {


    /**
     * 19. 删除链表的倒数第 N 个结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmpNode = head;
        int sz = 1;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
            sz ++;
        }
        if (n>sz) return null;
        int num = sz - n + 1;
        if (num == 1) {
            return head.next;
        }else if (num == sz) {
            tmpNode = head;
            for (int i = 1; i < sz-1; i++) {
                tmpNode = tmpNode.next;
            }
            tmpNode.next = null;
            return head;
        }else {
            tmpNode = head;
            for (int i = 1; i < num-1; i++) {
                tmpNode = tmpNode.next;
            }
            tmpNode.next = tmpNode.next.next;
        }
        return head;
    }

    /**
     * 61. 旋转链表
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode tmpNode = head;
        int nodeLength = 1;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
            nodeLength ++;
        }
        tmpNode.next = head;
        k = k % nodeLength;
        for (int i = 0; i < nodeLength-k-1; i++) {
            head = head.next;
        }
        ListNode tmp = head;
        head = head.next;
        tmp.next = null;
        return head;
    }
    /**
     * 75,颜色分类
     */
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int k = 0;
        int tmp = 0;
        while (i<j) {
            if (nums[i] == 0) {
                i ++;
                continue;
            }
            if (nums[j] != 0) {
                j --;
                continue;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i ++;
            j --;
        }
        if (nums[i] == 0) i ++;
        j = nums.length -1;
        while (i < j) {
            if (nums[i] == 1) {
                i ++;
                continue;
            }
            if (nums[j] != 1) {
                j --;
                continue;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i ++;
            j --;
        }
    }

    /**
     * 75,颜色分类
     *  -- 单指针
     */
    public void sortColors02(int[] nums){
        int p = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
                p ++;
            }
        }
        for (int i = p; i < nums.length; i++) {
            if (nums[i] == 1) {
                tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
                p ++;
            }
        }
    }


    /**
     * 189. 轮转数组
     */
    public void rotate(int[] nums, int k) {
        int[] tmp = Arrays.copyOfRange(nums, 0, nums.length);
        int len = nums.length;
        int index = len - k%len;
        int index_ = 0;
        for (int i = index; i <len; i++) {
            nums[index_] = tmp[i];
            index_ ++;
        }
        for (int i = 0; i <index; i++) {
            nums[index_] = tmp[i];
            index_ ++;
        }
    }

    /**
     * 31. 下一个排列
     * 思路: 从右向左,找到第一个降序的索引,再从右向左找到可以交换的数字,交换后,索引右边的数字升序排列
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length -2;
        while (i >= 0) {
            if (nums[i]>=nums[i+1]) {
                i --;
                continue;
            }else {
                break;
            }
        }
        i = i>= 0 ? i : 0;
        int j = nums.length -1;
        while (i < j) {
            if (nums[i]>=nums[j]){
                j --;
                continue;
            }else {
                break;
            }
        }
        swrap(nums,i,j);
        if (i ==0 && j ==0) {
            i --;
        }
        reverse_(nums,i+1,nums.length-1);
    }

    private void reverse_(int[] nums, int i, int j) {
        while (i < j) {
            swrap(nums,i, j);
            i ++;
            j --;
        }
    }

    private void swrap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    @Test
    void test() {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
