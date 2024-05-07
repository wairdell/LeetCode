package com.wairdell.leetcode.problems.structure.linked;

import com.wairdell.leetcode.structure.ListNode;

import java.util.List;

/**
 * date   : 2024/5/7 18:28
 * desc   : 反转链表 https://leetcode.cn/problems/reverse-linked-list
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode next = null;
        while (head != null) {
            next = new ListNode(head.val, next);
            head = head.next;
        }
        return next;
    }

}
