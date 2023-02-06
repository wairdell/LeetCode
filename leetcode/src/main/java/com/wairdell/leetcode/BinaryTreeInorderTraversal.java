package com.wairdell.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * author : fengqiao
 * date   : 2023/2/6 16:19
 * desc   : 二叉树的中序遍历 https://leetcode.cn/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }
        arrayList.addAll(inorderTraversal(root.left));
        arrayList.add(root.val);
        arrayList.addAll(inorderTraversal(root.right));
        return arrayList;
    }


}
