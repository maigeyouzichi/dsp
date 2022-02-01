package com.lz.other;

import com.lz.entity.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 两数之和
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * @author lihao
 * @date 2021-11-17 11:06
 */
@SuppressWarnings("all")
public class AddTwoNumbers {

    @Test
    void test(){

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //虚拟一个头结点
        ListNode head = new ListNode();
        ListNode curr = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1== null? 0 :l1.val;
            if (l1 != null) l1 = l1.next;
            int b = l2== null? 0 :l2.val;
            if (l2 != null) l2 = l2.next;
            int sum = (a+b+carry)%10;
            carry = (a+b+carry)/10;
            curr.next = new ListNode(sum);
            curr = curr.next;
        }
        if (carry >0) curr.next = new ListNode(carry);
        return head.next;
    }
}
