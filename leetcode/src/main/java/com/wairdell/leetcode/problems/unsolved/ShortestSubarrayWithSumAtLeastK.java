package com.wairdell.leetcode.problems.unsolved;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * date   : 2024/4/30 13:34
 * desc   : 和至少为 K 的最短子数组 https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k
 */
public class ShortestSubarrayWithSumAtLeastK {

    public static void main(String[] args) {
        ShortestSubarrayWithSumAtLeastK leastK = new ShortestSubarrayWithSumAtLeastK();
//        System.out.println(leastK.shortestSubarray(new int[]{1}, 1)); //1
//        System.out.println(leastK.shortestSubarray(new int[]{1, 4}, 4)); //1
//        System.out.println(leastK.shortestSubarray(new int[]{1, 4}, 5)); //2
//        System.out.println(leastK.shortestSubarray(new int[]{2, -1, 2}, 3));
//        System.out.println(leastK.shortestSubarray(new int[]{48, 99, 37, 4, -31}, 140));
        System.out.println(leastK.shortestSubarray(new int[]{1, 2, 3, 4, 5, 6, -20, -10, 20, 7, 8}, 7));
    }

    public class CustomQueue {

        private TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        private LinkedList<Integer> deque = new LinkedList<>();

        private int n;

        private CustomQueue(int n) {
            this.n = n;
        }

        private void reduce(int n) {
            while (deque.size() > n) {
                Integer first = deque.pollFirst();
                treeMap.remove(first);
            }
        }

        private void push(int val, int index) {
            if (deque.size() > n) {
                Integer first = deque.pollFirst();
                treeMap.remove(first);
            }
            deque.push(val);
            treeMap.put(val, index);
        }

        private int find(int target) {
            if (treeMap.firstKey() > target) {
                return -1;
            }
            for (int i = 0; i < deque.size(); i++) {
                if (deque.get(i) <= target) {
                    return i + 1;
                }
            }
            return -1;
        }

    }

    public int shortestSubarray(int[] nums, int k) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        CustomQueue queue = new CustomQueue(nums.length);
        queue.push(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int find = queue.find(sum - k);
            if (find > 0) {
                min = find;
                if (min == 1) {
                    return 1;
                }
                queue.reduce(min - 1);
            }
            queue.push(sum, i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
