package com.wairdell.leetcode.problems.structure.linked;

import com.wairdell.leetcode.structure.ListNode;

/**
 * date   : 2024/4/30 18:08
 * desc   : 环形链表 II https://leetcode.cn/problems/linked-list-cycle-ii
 */
public class LinkedListCycleII {

    public static void main(String[] args) {
        LinkedListCycleII cycleII = new LinkedListCycleII();
        ListNode head = new ListNode(3);
        ListNode tail = head;
        for (int num : new int[]{2, 0, 4}) {
            ListNode node = new ListNode(num);
            tail.next = node;
            tail = node;
        }
        tail.next = head.next;
        System.out.println(cycleII.detectCycle(head).val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fastNode = head.next;
        ListNode slowNode = head;
        while (fastNode != slowNode) {
            if (fastNode == null || fastNode.next == null) {
                return null;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return fastNode;
    }

}
