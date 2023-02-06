package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/6 17:23
 * desc   : 计算布尔二叉树的值 https://leetcode.cn/problems/evaluate-boolean-binary-tree/
 */
public class EvaluateBooleanBinaryTree {

    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left != null) {
            boolean leftResult = evaluateTree(root.left);
            boolean rightResult = evaluateTree(root.right);
            if (root.val == 2) {
                return leftResult || rightResult;
            } else {
                return leftResult && rightResult;
            }
        }
        return root.val == 1;
    }



}
