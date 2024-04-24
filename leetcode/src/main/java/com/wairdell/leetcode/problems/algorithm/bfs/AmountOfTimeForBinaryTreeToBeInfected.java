package com.wairdell.leetcode.problems.algorithm.bfs;

import com.wairdell.leetcode.structure.TreeNode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * date   : 2024/4/24 9:33
 * desc   : 感染二叉树需要的总时间 https://leetcode.cn/problems/amount-of-time-for-binary-tree-to-be-infected
 */
public class AmountOfTimeForBinaryTreeToBeInfected {

    public static void main(String[] args) {
        AmountOfTimeForBinaryTreeToBeInfected.Impl amount = new AmountOfTimeForBinaryTreeToBeInfected.Impl();
        TreeNode left = null;
        TreeNode right = null;
        TreeNode root = null;
        /*left = new TreeNode(9);
        right = new TreeNode(2);
        root = new TreeNode(4, left, right);
        root = new TreeNode(5, null, root);

        left = new TreeNode(10);
        right = new TreeNode(6);
        right = new TreeNode(3, left, right);
        root = new TreeNode(1, root, right);
        System.out.println(amount.amountOfTime(root, 1));*/

        /*root = new TreeNode(5);
        root = new TreeNode(4, root, null);
        root = new TreeNode(3, root, null);
        root = new TreeNode(2, root, null);
        root = new TreeNode(1, root, null);

        System.out.println(amount.amountOfTime(root, 1));*/

        right = new TreeNode(5);
        left = new TreeNode(3, null, right);
        right = new TreeNode(4);
        root = new TreeNode(2, left, right);
        root = new TreeNode(1, null, root);
        System.out.println(amount.amountOfTime(root, 1));
    }

    static class Impl {

        public int amountOfTime(TreeNode root, int start) {
            TreeNode target = null;
            Set<TreeNode> nodeSet = new HashSet<>();
            nodeSet.add(root);
            Map<TreeNode, TreeNode> parent = new HashMap<>();
            while (target == null && !nodeSet.isEmpty()) {
                Set<TreeNode> nextSet = new HashSet<>();
                for (TreeNode treeNode : nodeSet) {
                    if (treeNode.val == start) {
                        target = treeNode;
                        break;
                    } else {
                        if (treeNode.left != null) {
                            nextSet.add(treeNode.left);
                            parent.put(treeNode.left, treeNode);
                        }
                        if (treeNode.right != null) {
                            nextSet.add(treeNode.right);
                            parent.put(treeNode.right, treeNode);
                        }
                    }
                    nodeSet = nextSet;
                }
            }
            Map<TreeNode, TreeNode> discardParent = new HashMap<>(parent);
            parent.clear();
            TreeNode child = target;
            while (discardParent.containsKey(child)) {
                parent.put(child, discardParent.get(child));
                child = discardParent.get(child);
            }
            int deep = 0;
            nodeSet.clear();
            nodeSet.add(target);
            while (!nodeSet.isEmpty()) {
                Set<TreeNode> nextSet = new HashSet<>();

                for (TreeNode treeNode : nodeSet) {
                    if (parent.containsKey(treeNode)) {
                        nextSet.add(parent.get(treeNode));
                    }
                    if (treeNode.left != null && !parent.containsKey(treeNode.left)) {
                        nextSet.add(treeNode.left);
                    }
                    if (treeNode.right != null && !parent.containsKey(treeNode.right)) {
                        nextSet.add(treeNode.right);
                    }
                }
                nodeSet = nextSet;
                deep++;
            }
            return deep - 1;
        }
    }

    static class DiscardImpl {

        public void addNextSet(Set<TreeNode> nextSet,
                               TreeNode treeNode, TreeNode nextNode,
                               Map<TreeNode, String> pathMap, String mark,
                               Map<TreeNode, Integer> nextDeepMap, int[] maxNextDeep) {
            nextSet.add(nextNode);
            if (pathMap != null) pathMap.put(nextNode, pathMap.get(treeNode) + mark);
            if (nextDeepMap.get(treeNode) != null) {
                Integer nextDeep = nextDeepMap.get(treeNode);
                if (nextDeep < 0) {
                    nextDeepMap.put(nextNode, nextDeep - 1);
                    maxNextDeep[0] = nextDeep - 1;
                } else {
                    nextDeepMap.put(nextNode, nextDeep + 1);
                    maxNextDeep[1] = nextDeep + 1;
                }
            }
//        if (treeNode.left.val == start) targetNode = treeNode.left;
        }

        public int amountOfTime(TreeNode root, int start) {
//        if (root.val == start)  return 0;
            Set<TreeNode> nodeSet = new HashSet<>();
            nodeSet.add(root);
            Map<TreeNode, String> pathMap = new HashMap<>();
            pathMap.put(root, "");

            Map<TreeNode, Integer> nextDeep = new HashMap<>();
            int[] maxNextDeep = new int[]{-1, 1};

            int deep = 0;
            int bifurcation = 0;
            int backDeep = 0;
            while (!nodeSet.isEmpty()) {
                TreeNode targetNode = null;
                Set<TreeNode> nextSet = new HashSet<>();
                for (TreeNode treeNode : nodeSet) {
                    if (treeNode.left != null) {
                        addNextSet(nextSet, treeNode, treeNode.left, pathMap, "l", nextDeep, maxNextDeep);
                        if (treeNode.left.val == start) targetNode = treeNode.left;
                    }
                    if (treeNode.right != null) {
                        addNextSet(nextSet, treeNode, treeNode.right, pathMap, "r", nextDeep, maxNextDeep);
                        if (treeNode.right.val == start) targetNode = treeNode.right;
                    }
                    if (pathMap != null && (treeNode.right != null || treeNode.left != null)) {
                        pathMap.remove(treeNode);
                    }
                }
                if (nextSet.isEmpty()) break;
                nodeSet = nextSet;
                deep++;

                if (targetNode != null && pathMap != null) {
                    Map<TreeNode, String> p = pathMap;
                    pathMap = null;
                    if (p.size() == 1) {
                        backDeep = deep;
                        continue;
                    }
                    for (TreeNode treeNode : nextSet) {
                        if (treeNode == targetNode) {
                            nextDeep.put(treeNode, - 1);
                            continue;
                        }
                        nextDeep.put(treeNode, 1);
                    }
                    Set<Map.Entry<TreeNode, String>> entrySet = p.entrySet();
                    for (Map.Entry<TreeNode, String> entry : entrySet) {
                        if (entry.getKey() == targetNode) continue;
                        String path1 = p.get(targetNode);
                        String path2 = entry.getValue();
                        int n = Math.min(path2.length(), path1.length());
                        for (int i = 0; i < n; i++) {
                            if (path1.charAt(i) != path2.charAt(i)) {
                                bifurcation = Math.max(bifurcation, n - i);
                                break;
                            }
                        }
                    }
                }
            }
            if (backDeep > 0) {
                return Math.max(backDeep, deep - backDeep);
            } else if (Math.abs(maxNextDeep[0]) > Math.abs(maxNextDeep[1])) {
                return deep + Math.max(0, bifurcation + maxNextDeep[0] + maxNextDeep[1]);
            } else if (Math.abs(maxNextDeep[0]) < Math.abs(maxNextDeep[1])){
                return deep + bifurcation ;
            } else {
                return deep + bifurcation;
            }
//        return deep + bifurcation + maxNextDeep[0] + maxNextDeep[1];

        }

    }



}
