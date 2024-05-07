package com.wairdell.leetcode.structure;

/**
 * author : fengqiao
 * date   : 2023/2/9 13:48
 * desc   :
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
