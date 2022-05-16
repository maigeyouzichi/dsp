package com.lz.nodeList;

import com.lz.entity.ListNode;
import lombok.val;
import org.junit.Test;

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

    /**
     * 21. 合并两个有序链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 ==null || list2==null) return list1 != null?list1:list2;
        ListNode tmp;
        if(list1.val>list2.val) {
            tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        ListNode curr = list1;
        ListNode other = list2;
        while(curr.next != null && other!=null) {
            if(curr.next.val > other.val) {
                tmp = curr.next;
                curr.next = other;
                curr = other;
                other = tmp;
            }else {
                curr = curr.next;
            }
        }
        if(other == null) return list1;
        if(curr.next == null) curr.next = other;
        return list1;
    }

    @Test
    public void test001() {
        ListNode list1 = new ListNode(2);
        ListNode list2 = new ListNode(1);
        ListNode res = mergeTwoLists(list1, list2);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
