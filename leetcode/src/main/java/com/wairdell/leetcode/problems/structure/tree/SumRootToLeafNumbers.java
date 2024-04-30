package com.wairdell.leetcode.problems.structure.tree;

import com.wairdell.leetcode.structure.TreeNode;

/**
 * date   : 2024/4/30 17:43
 * desc   : 求根节点到叶节点数字之和 https://leetcode.cn/problems/sum-root-to-leaf-numbers
 */
public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        SumRootToLeafNumbers numbers = new SumRootToLeafNumbers();
        TreeNode root = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        System.out.println(numbers.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int val) {
        if (root.left == null && root.right == null) {
            return val + root.val;
        }
        int sum = 0;
        if (root.left != null) {
            sum += sumNumbers(root.left, (val + root.val) * 10);
        }
        if (root.right != null) {
            sum += sumNumbers(root.right, (val + root.val) * 10);
        }
        return sum;
    }

}
