package com.lz.doublePointer;

import com.lz.entity.ListNode;

import java.util.HashMap;

/**
 * 双指针 简单
 */
public class DoublePointerSimple {

    /**
     * 1342. 将数字变成 0 的操作次数
     */
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if ((num&1)==1) {
                num -= 1;
                count += 1;
            }else {
                num = num/2;
                count ++;
            }
        }
        return count;
    }

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
}
