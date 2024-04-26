package com.wairdell.leetcode.problems.structure.queue;

import java.util.Arrays;

/**
 * date   : 2024/4/24 15:26
 * desc   : 滑动窗口最大值 https://leetcode.cn/problems/sliding-window-maximum
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum.SegmentTreeImpl maximum = new SlidingWindowMaximum.SegmentTreeImpl();
//        int[] ans = maximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

        int[] input = new int[100000];
        for (int i = 0; i < 10000; i++) {
            input[i] = 10000 - i;
        }

        int[] ans = maximum.maxSlidingWindow(input, 10000);
        System.out.println(Arrays.toString(ans));

    }

    static class SegmentTreeImpl {


        static class Node {
            int l;
            int r;
            int val;
        }

        static class SegmentTree {

            int[] nums;
            Node[] tree;

            SegmentTree(int[] nums) {
                this.nums = nums;
                tree = new Node[nums.length * 4];
                for (int i = 0; i < tree.length; i++) {
                    tree[i] = new Node();
                }
                build(0, 0, nums.length - 1);
            }

            void build(int k, int l, int r) {
                Node node = tree[k];
                node.l = l;
                node.r = r;
                if (l == r) {
                    node.val = nums[l];
                    return;
                }
                int mid = (l + r) / 2;
                int leftChild = k * 2 + 1;
                int rightChild = k * 2 + 2;
                build(leftChild, l, mid);
                build(rightChild, mid + 1, r);
                node.val = Math.max(tree[leftChild].val, tree[rightChild].val);
            }

            int query(int k, int l, int r) {
                Node node = tree[k];
                if (node.l >= l && node.r <= r) {
                    return node.val;
                }
                int mid = (node.l + node.r) / 2;
                int max = Integer.MIN_VALUE;
                if (l <= mid) {
                    max = Math.max(query(k * 2 + 1, l, r), max);
                }
                if (r > mid) {
                    max = Math.max(query(k * 2 + 2, l, r), max);
                }
                return max;
            }

        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] ans = new int[nums.length - k + 1];
            SegmentTree segmentTree = new SegmentTree(nums);
            for (int i = 0; i < nums.length - k + 1; i++) {
                ans[i] = segmentTree.query(0, i, i + k);
            }
            return ans;
        }

    }

    static class MonotoneQueueImpl {

        static class MonotoneQueue {

            private static final int INF = 0;
            int n;
            int[] queue;
            int count;
            int start;

            MonotoneQueue(int n) {
                this.n = n;
                queue = new int[n];
            }

            private int first() {
                return queue[start];
            }

            private int lastIndex() {
                return (start + count - 1) % n;
            }

            private int last() {
                return queue[lastIndex()];
            }

            private boolean isEmpty() {
                return count == 0;
            }

            private void removeLast() {
                queue[lastIndex()] = INF;
                count--;
            }

            private void addLast(int value) {
                count++;
                queue[lastIndex()] = value;
            }

            public void push(int value) {
                while (!isEmpty() && last() < value) {
                    removeLast();
                }
                addLast(value);
            }

            private void removeFirst() {
                queue[start] = INF;
                count--;
                start = (start + 1) % n;
            }

            public void pop(int value) {
                if (first() == value) {
                    removeFirst();
                }
            }

        }

    /*static class MonotoneQueue {

        Deque<Integer> deque = new ArrayDeque<>();

        public void push(int value) {
            while (!deque.isEmpty() && deque.getLast() < value) {
                deque.pollLast();
            }
            deque.addLast(value);
        }

        public void pop(int value) {
            if (deque.getFirst() == value) {
                deque.pollFirst();
            }
        }

        public int getTop() {
            return deque.getFirst();
        }

    }*/

        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] ans = new int[nums.length - k + 1];
            MonotoneQueue monotoneQueue = new MonotoneQueue(k);
            for (int i = 0; i < k; i++) {
                monotoneQueue.push(nums[i]);
            }
            for (int i = k; i <= nums.length; i++) {
                ans[i - k] = monotoneQueue.first();
                if (i == nums.length) continue;
                monotoneQueue.pop(nums[i - k]);
                monotoneQueue.push(nums[i]);
            }
            return ans;
        }


    }


}
