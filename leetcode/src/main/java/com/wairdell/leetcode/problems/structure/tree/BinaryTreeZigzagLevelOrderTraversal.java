package com.wairdell.leetcode.problems.structure.tree;

import com.wairdell.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * date   : 2024/5/8 10:09
 * desc   : 二叉树的锯齿形层序遍历 https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> set = new ArrayList<>();
        set.add(root);
        boolean ltf = true;
        while (!set.isEmpty()) {
            List<TreeNode> nextSet = new ArrayList<>();
            List<Integer> list = new ArrayList<>();

            for (TreeNode treeNode : set) {
                list.add(treeNode.val);

                if (treeNode.left != null && treeNode.right != null) {
                    nextSet.add(0, ltf ? treeNode.left : treeNode.right);
                    nextSet.add(0, ltf ? treeNode.right : treeNode.left);
                } else if (treeNode.left != null) {
                    nextSet.add(0, treeNode.left);
                } else if (treeNode.right != null) {
                    nextSet.add(0, treeNode.right);
                }
            }
            ltf = !ltf;
            ans.add(list);

            set = nextSet;
        }
        return ans;
    }

}
