package com.wairdell.leetcode.problems.unsolved;

import com.wairdell.leetcode.structure.ListNode;

/**
 * date   : 2024/4/30 17:18
 * desc   : 排序链表 https://leetcode.cn/problems/sort-list
 */
public class SortList {

    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode head = new ListNode(4);
        ListNode next = head;
        int[] ints = {2, 1, 3};
        for (int num : ints) {
            ListNode node = new ListNode(num);
            next.next = node;
            next = node;
        }
        System.out.println(sortList.sortList(head));
        System.out.println();
    }

    public ListNode sortList(ListNode head) {
        ListNode next = head;
        while (next != null) {
            ListNode current = head;
            next = next.next;
            while (current.next != null) {
                if (current.val > current.next.val) {
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val = temp;
                }
                current = current.next;
            }
        }
        return head;
    }

}
