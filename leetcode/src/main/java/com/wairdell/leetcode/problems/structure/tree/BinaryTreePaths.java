package com.wairdell.leetcode.problems.structure.tree;

import com.wairdell.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * date   : 2024/5/8 17:04
 * desc   : 二叉树的所有路径 https://leetcode.cn/problems/binary-tree-paths
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.emptyList();
        return binaryTreePaths(root, "");
    }

    public List<String> binaryTreePaths(TreeNode root, String prefix) {
        if (root.left == null && root.right == null) {
            return Collections.singletonList(prefix + root.val);
        }
        List<String> ans = new ArrayList<>();
        if (root.left != null) {
            ans.addAll(binaryTreePaths(root.left, prefix + root.val + "->"));
        }
        if (root.right != null) {
            ans.addAll(binaryTreePaths(root.right, prefix + root.val + "->"));
        }
        return ans;
    }

}
