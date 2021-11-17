package com.lz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lihao
 * @date 2021-11-15 09:40
 */
@Data
@NoArgsConstructor
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
}
