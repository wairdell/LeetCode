package com.wairdell.leetcode.problems;

import java.math.BigDecimal;

/**
 * date   : 2024/5/9 17:31
 * desc   : 区间和的个数 https://leetcode.cn/problems/count-of-range-sum
 */
public class CountOfRangeSum {

    public static void main(String[] args) {
        CountOfRangeSum rangeSum = new CountOfRangeSum();
        System.out.println(rangeSum.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
        System.out.println(rangeSum.countRangeSum(new int[]{0}, 0, 0));
        System.out.println(rangeSum.countRangeSum(new int[]{-2, 5, -1, 1, 2, -3, 3}, -4, 4));
        System.out.println(rangeSum.countRangeSum(new int[]{-2147483647, 0, -2147483647, 2147483647}, -564, 3864));
//        System.out.println(-2147483647 + -2147483647);
    }

    public static class SegmentTree {

        static class Node {
            int l;
            int r;
            long val;

            public Node(int l, int r, long val) {
                this.l = l;
                this.r = r;
                this.val = val;
            }

            public Node(int l, int r) {
                this.l = l;
                this.r = r;
            }
        }

        private Node[] nodes;

        public SegmentTree(int[] nums) {
            nodes = new Node[nums.length * 4];
            buildTree(nums, 0, nums.length - 1, 0);
        }

        public void buildTree(int[] nums, int l, int r, int k) {
            if (l == r) {
                nodes[k] = new Node(l, r, nums[l]);
                return;
            }
            Node node = new Node(l, r);
            nodes[k] = node;
            int mid = (l + r) / 2;
            buildTree(nums, l, mid, k * 2 + 1);
            buildTree(nums, mid + 1, r, k * 2 + 2);
            node.val = nodes[k * 2 + 1].val + nodes[k * 2 + 2].val;
        }

        public long query(int l, int r) {
            return query(l, r, 0);
        }

        public long query(int l, int r, int k) {
            Node node = nodes[k];
            if (node.l >= l && node.r <= r) {
                return node.val;
            }
            int mid = (node.l + node.r) / 2;
            long ans = 0;
            if (l <= mid) {
                ans += query(l, r, k * 2 + 1);
            }
            if (r > mid) {
                ans += query(l, r, k * 2 + 2);
            }
            return ans;
        }

    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int ans = 0;
        SegmentTree segmentTree = new SegmentTree(nums);
        BigDecimal lowerDecimal = BigDecimal.valueOf(lower);
        BigDecimal bigDecimal = BigDecimal.valueOf(upper);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                long query = segmentTree.query(j, i);
                if (query >= lower && query <= upper) {
                    ans++;
                }
            }
        }

        /*BigDecimal[] sumArr = new BigDecimal[nums.length + 1];
        sumArr[0] = BigDecimal.ZERO;
        BigDecimal sum = BigDecimal.ZERO;
        int ans = 0;
        BigDecimal lowerDecimal = BigDecimal.valueOf(lower);
        BigDecimal bigDecimal = BigDecimal.valueOf(upper);
        for (int i = 0; i < nums.length; i++) {
            sum = sum.add(new BigDecimal(nums[i]));
            for (int j = 0; j <= i; j++) {
                BigDecimal subtract = sum.subtract(sumArr[j]);
                if (subtract.compareTo(lowerDecimal) >= 0 && subtract.compareTo(bigDecimal) <= 0) {
                    ans++;
                }
            }
            sumArr[i + 1] = sum;
        }*/
        return ans;
    }

}
