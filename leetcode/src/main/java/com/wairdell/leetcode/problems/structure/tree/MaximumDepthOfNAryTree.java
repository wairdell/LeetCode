package com.wairdell.leetcode.problems.structure.tree;

import java.util.List;

/**
 * date   : 2024/5/7 14:10
 * desc   : N 叉树的最大深度 https://leetcode.cn/problems/maximum-depth-of-n-ary-tree
 */
public class MaximumDepthOfNAryTree {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        return depth(root);
    }

    public int depth(Node root) {
        if (root == null) return 0;
        if (root.children == null || root.children.isEmpty()) return 1;
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(depth(child), max);
        }
        return max + 1;
    }

}
