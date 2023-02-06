package com.wairdell.leetcode;

import java.util.Stack;

/**
 * author : fengqiao
 * date   : 2023/2/6 16:55
 * desc   : 路径总和 https://leetcode.cn/problems/path-sum/
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            if (pop.val == targetSum && (pop.left == null && pop.right == null)) {
                return true;
            }
            if (pop.left != null) {
                pop.left.val = pop.left.val + pop.val;
                stack.push(pop.left);
            }
            if (pop.right != null) {
                pop.right.val = pop.right.val + pop.val;
                stack.push(pop.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        System.out.println("result = " + new PathSum().hasPathSum(treeNode, 6));
    }


}
