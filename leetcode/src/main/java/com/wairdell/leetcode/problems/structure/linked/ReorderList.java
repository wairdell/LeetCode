package com.wairdell.leetcode.problems.structure.linked;

import com.wairdell.leetcode.structure.ListNode;

import java.util.Stack;

/**
 * date   : 2024/5/8 14:27
 * desc   : 重排链表 https://leetcode.cn/problems/reorder-list
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode head = null;
        ListNode next = null;
        for (int num : new int[]{1, 2, 3, 4, 5}) {
            ListNode addNode = new ListNode(num);
            if (head == null) {
                head = addNode;
            } else {
                next.next = addNode;
            }
            next = addNode;
        }
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(head);

        /*while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }*/
    }

    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        Stack<ListNode> stack = new Stack<>();
        ListNode previous = slow;
        while (fast != null) {
            fast = fast.next;
            previous = slow;
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        if (previous != null) {
            previous.next = null;
        }

        ListNode temp = null;
        while (slow != null) {
            stack.add(slow);
            temp = slow.next;
            slow.next = null;
            slow = temp;
        }

        ListNode next = head;
        while (!stack.isEmpty()) {
            temp = next.next;

            ListNode node = stack.pop();

            next.next = node;
            node.next = temp;

            next = temp;
        }
    }

}
