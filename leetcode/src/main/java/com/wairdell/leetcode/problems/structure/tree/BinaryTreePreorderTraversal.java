package com.wairdell.leetcode.problems.structure.tree;

import com.wairdell.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * date   : 2024/4/30 17:53
 * desc   : 二叉树的前序遍历 https://leetcode.cn/problems/binary-tree-preorder-traversal
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
//        if (root.left == null && root.right == null) return Collections.singletonList(root.val);
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        /*if (root.left != null) {
            ans.add(root.left.val);
        }
        if (root.right != null) {
            ans.add(root.right.val);
        }*/
        if (root.left != null) {
            ans.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            ans.addAll(preorderTraversal(root.right));
        }
        return ans;
    }


}
