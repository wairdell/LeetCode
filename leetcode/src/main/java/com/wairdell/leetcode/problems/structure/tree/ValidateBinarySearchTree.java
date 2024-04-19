package com.wairdell.leetcode.problems.structure.tree;

import com.wairdell.leetcode.structure.TreeNode;

/**
 * author : fengqiao
 * date   : 2023/2/6 16:30
 * desc   : 验证二叉搜索树 https://leetcode.cn/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        if (!isValidBST(root.left, min, root.val)) {
            return false;
        }
        if (!isValidBST(root.right, root.val, max)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
       /* TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);*/

        TreeNode treeNode = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        treeNode.left = left;

        TreeNode right = new TreeNode(2);
        left.right = right;

        right.right = new TreeNode(3);

        System.out.println("result = " + new ValidateBinarySearchTree().isValidBST(treeNode));
    }

}
