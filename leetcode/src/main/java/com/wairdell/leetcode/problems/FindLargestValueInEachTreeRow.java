package com.wairdell.leetcode.problems;

import com.wairdell.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * date   : 2024/5/7 17:34
 * desc   : 在每个树行中找最大值 https://leetcode.cn/problems/find-largest-value-in-each-tree-row
 */
public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return Collections.emptyList();
        return largestValues(new HashSet<>(Arrays.asList(root)));
    }

    public List<Integer> largestValues(Set<TreeNode> set) {
        Set<TreeNode> nextSet = new HashSet<>();
        Integer max = null;
        for (TreeNode treeNode : set) {
            if (max == null) {
                max = treeNode.val;
            } else {
                max = Math.max(max, treeNode.val);
            }
            if (treeNode.left != null) {
                nextSet.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nextSet.add(treeNode.right);
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(max);
        if (!nextSet.isEmpty()) {
            ans.addAll(largestValues(nextSet));
        }
        return ans;
    }

}
