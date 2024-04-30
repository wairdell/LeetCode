package com.wairdell.leetcode.problems.easy;

import com.wairdell.leetcode.structure.ListNode;

/**
 * date   : 2024/4/28 16:21
 * desc   : 两数相加 https://leetcode.cn/problems/add-two-numbers
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode ans = null;
        ListNode tail = null;
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + pre;
            ListNode node = new ListNode(sum % 10);
            if (ans == null) {
                ans = node;
            } else {
                tail.next = node;
            }
            tail = node;
            pre = sum / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (pre > 0) {
            tail.next = new ListNode(pre);
        }
        return ans;
    }

}
