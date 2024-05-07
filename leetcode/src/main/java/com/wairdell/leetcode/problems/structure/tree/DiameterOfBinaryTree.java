package com.wairdell.leetcode.problems.structure.tree;

import com.wairdell.leetcode.structure.TreeNode;

/**
 * date   : 2024/5/7 10:55
 * desc   : 二叉树的直径 https://leetcode.cn/problems/diameter-of-binary-tree
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        return depth(root)[0];
    }

    public int[] depth(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = depth(root.left);
        int[] right = depth(root.right);
        int max = Math.max(left[0], right[0]);
        max = Math.max(left[1] + right[1], max);
        return new int[]{max, Math.max(left[1], right[1]) + 1};
    }

}
