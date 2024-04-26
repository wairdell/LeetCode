package com.wairdell.leetcode.exapmle;

/**
 * date   : 2024/4/25 10:27
 * desc   : 线段树
 */
public class SegmentTree {

    private Node[] tree;
    private int[] nums;

    static class Node {
        int l;
        int r;
        int val;
    }

    public SegmentTree(int[] nums) {
        this.nums = nums;
        tree = new Node[nums.length * 4];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }
    }

    private void buildTree(int k, int l, int r) {
        Node node = tree[k];
        node.l = l;
        node.r = r;
        if (l == r) {
            //叶子节点的值就是原有数组的值，叶子节点的l和r就是原有数组的索引
            node.val = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        int leftChild = k * 2 + 1;
        //构建左节点
        buildTree(leftChild, l, mid);
        int rightChild = k * 2 + 2;
        //构建右节点
        buildTree(rightChild, mid + 1, r);

        //根据左右节点的值来确认当前节点的值
        node.val = Math.max(tree[leftChild].val, tree[rightChild].val);
    }

    public void update(int i, int v) {
        update(0, i, v);
    }

    /**
     * @param k 平衡二叉树的索引下标
     * @param i 原数组位置的索引
     * @param v 更新的值
     */
    private void update(int k, int i, int v) {
        Node node = tree[k];
        //l == r 就是叶子节点，叶子节点的l就是原数组的索引
        if (node.l == node.r && node.l == i) {
            node.val = v;
            return;
        }
        int mid = (node.l + node.r) / 2;
        //更新的索引小于当前区间节点的中点，说明在左节点上，否则在右节点上
        if (i <= mid) {
            update(k * 2 + 1, i, v);
        } else {
            update(k * 2 + 2, i, v);
        }
        node.val = Math.max(tree[k * 2 + 1].val, tree[k * 2 + 2].val);
    }

    public int query(int l, int r) {
        return query(0, l, r);
    }

    private int query(int k, int l, int r) {
        Node node = tree[k];
        //当前节点的区间已经在查询的区间内，则直接返回构建好的节点值
        //注:这里不是非要查询到叶子节点，只用把构建好的在查询区间内的区间节点值返回即可，这也是线段树的意义，减少查询次数
        if (node.l >= l && node.r <= r) {
            return node.val;
        }
        int mid = (node.l + node.r) / 2;
        int max = Integer.MIN_VALUE;
        if (l <= mid) {
            //如果要查询的区间的开始范围小于当前访问节点区间的中间值，说明当前节点的左节点是包含查询区间的范围的
            max = Math.max(query(k * 2 + 1, l, r), max);
        }
        if (r > mid) {
            //同上
            max = Math.max(query(k * 2 + 2, l, r), max);
        }
        return max;
    }

}
