package com.wairdell.leetcode.problems.structure.linked;

import com.wairdell.leetcode.structure.ListNode;

/**
 * date   : 2024/5/7 18:32
 * desc   : 反转链表 II https://leetcode.cn/problems/reverse-linked-list-ii
 */
public class ReverseLinkedListII {

    public static void main(String[] args) {
        ReverseLinkedListII listII = new ReverseLinkedListII();
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

        ListNode ans = listII.reverseBetween(head, 2, 4);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode srcNext = head;
        ListNode destHead = null;
        ListNode destNext = null;
        ListNode reverseNext = null;
        ListNode reverseTail = null;
        int k = 0;
        while (srcNext != null) {
            k++;
            if (k >= left && k <= right) {
                reverseNext = new ListNode(srcNext.val, reverseNext);
                if (reverseTail == null) {
                    reverseTail = reverseNext;
                }
                if (k == right) {
                    if (destHead == null) {
                        destHead = reverseNext;
                    } else {
                        destNext.next = reverseNext;
                    }
                    destNext = reverseTail;
                }
            } else {
                ListNode tailNode = new ListNode(srcNext.val);
                if (destHead == null) {
                    destHead = tailNode;
                } else {
                    destNext.next = tailNode;
                }
                destNext = tailNode;
            }
            srcNext = srcNext.next;
        }
        return destHead;
    }

}
