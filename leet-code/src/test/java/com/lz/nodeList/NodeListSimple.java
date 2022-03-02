package com.lz.nodeList;

import com.lz.entity.ListNode;

/**
 * @author lihao on 2022/3/1
 */
@SuppressWarnings("all")
public class NodeListSimple {

    /**
     * 206. 反转链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr!=null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
