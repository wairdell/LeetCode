package com.wairdell.leetcode.problems.structure.tree;

import com.wairdell.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * date   : 2024/5/8 17:41
 * desc   : 对称二叉树 https://leetcode.cn/problems/symmetric-tree
 */
public class SymmetricTree {

    private boolean treeNodeEquals(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        List<TreeNode> left = new ArrayList<>();
        left.add(root.left);
        List<TreeNode> right = new ArrayList<>();
        right.add(root.right);
        while (left.size() == right.size() && !left.isEmpty()) {
            List<TreeNode> nextLeft = new ArrayList<>();
            List<TreeNode> nextRight = new ArrayList<>();

            for (int i = 0; i < left.size(); i++) {
                TreeNode leftNode = left.get(i);
                TreeNode rightNode = right.get(i);
                if (!treeNodeEquals(leftNode, rightNode)) return false;
                if (leftNode != null) {
                    nextLeft.add(leftNode.left);
                    nextLeft.add(leftNode.right);

                    nextRight.add(rightNode.left);
                    nextRight.add(rightNode.right);
                }
            }

            left = nextLeft;
            right = nextRight;
        }
        return left.size() == right.size();
    }

}
