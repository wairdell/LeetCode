package com.wairdell.leetcode.problems.unsolved;

import com.wairdell.leetcode.structure.ListNode;

/**
 * date   : 2024/5/7 18:32
 * desc   : 反转链表 II https://leetcode.cn/problems/reverse-linked-list-ii
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode next = head;
        ListNode newHead = null;
        int k = 0;
        while (next != null) {
            k++;
            if (k == right) {

            } else if (k >= left) {

            } else {
                ListNode node = new ListNode(next.val);
                if (newHead != null) {
                    newHead.next = node;
                }
                newHead = node;
            }
            next = next.next;
        }
        return newHead;
    }

}
