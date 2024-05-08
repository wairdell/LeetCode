package com.wairdell.leetcode.problems.structure.tree;

import com.wairdell.leetcode.structure.TreeNode;

/**
 * date   : 2024/5/8 17:11
 * desc   : 完全二叉树的节点个数 https://leetcode.cn/problems/count-complete-tree-nodes
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
