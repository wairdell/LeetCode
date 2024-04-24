package com.wairdell.leetcode.problems.structure.queue;

import java.util.Arrays;

/**
 * date   : 2024/4/24 15:26
 * desc   : 滑动窗口最大值 https://leetcode.cn/problems/sliding-window-maximum
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum maximum = new SlidingWindowMaximum();
//        int[] ans = maximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

        int[] input = new int[100000];
        for (int i = 0; i < 10000; i++) {
            input[i] = 10000 - i;
        }

        int[] ans = maximum.maxSlidingWindow(input, 10000);
        System.out.println(Arrays.toString(ans));

       /* MonotoneQueue monotoneQueue = new MonotoneQueue();
        monotoneQueue.push(1);
        monotoneQueue.push(3);
        monotoneQueue.push(-1);*/

    }


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
