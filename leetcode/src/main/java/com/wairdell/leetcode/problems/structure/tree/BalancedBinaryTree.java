package com.wairdell.leetcode.problems.structure.tree;

import com.wairdell.leetcode.structure.TreeNode;

/**
 * date   : 2024/5/8 17:15
 * desc   : 平衡二叉树 https://leetcode.cn/problems/balanced-binary-tree
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        try {
            balanced(root);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public int balanced(TreeNode root) {
        if (root == null) return 0;
        int left = balanced(root.left);
        int right = balanced(root.right);
        if (Math.abs(left - right) > 1) {
            throw new RuntimeException();
        }
        return 1 + Math.max(left, right);
    }

}
