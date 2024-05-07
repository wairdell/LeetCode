package com.wairdell.leetcode.problems.structure.linked;

import com.wairdell.leetcode.structure.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * date   : 2024/5/7 18:16
 * desc   : 两数相加 II https://leetcode.cn/problems/add-two-numbers-ii
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }
        }
        int carry = 0;
        ListNode ans = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int num1 = s1.isEmpty() ? 0 : s1.pop();
            int num2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = num1 + num2 + carry;
            ans = new ListNode(sum % 10, ans);
            carry = sum / 10;
        }
        if (carry > 0) {
            ans = new ListNode(carry, ans);
        }
        return ans;
    }

}
