package com.wairdell.leetcode.problems.structure.linked;

import com.wairdell.leetcode.structure.ListNode;

/**
 * author : fengqiao
 * date   : 2023/2/9 13:48
 * desc   : 删除链表中的节点 https://leetcode.cn/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        //删除当前节点 在没有前驱节点的情况下 可以这个节点的对象信息改为下一节点
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
