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

    @Test
    void test() {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
