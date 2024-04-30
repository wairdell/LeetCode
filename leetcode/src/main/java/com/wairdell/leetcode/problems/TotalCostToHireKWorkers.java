package com.wairdell.leetcode.problems;

import java.util.Arrays;
import java.util.Collections;

/**
 * date   : 2024/5/1 19:58
 * desc   : 雇佣 K 位工人的总代价 https://leetcode.cn/problems/total-cost-to-hire-k-workers
 */
public class TotalCostToHireKWorkers {

    public static void main(String[] args) {
        TotalCostToHireKWorkers cost = new TotalCostToHireKWorkers();
//        System.out.println(cost.totalCost(new int[]{17, 12, 1, 10, 2, 7, 2, 3, 11, 20, 8}, 3, 3));
        System.out.println(cost.totalCost(new int[]{2, 1, 2}, 1, 1));
    }

    private static class Heap {

        private int[] nums;
        private int n;

        Heap(int[] nums) {
            this.nums = nums;
            n = nums.length;
            for (int i = (n - 2) / 2; i >= 0; i--) {
                shitDown(i);
            }
        }

        private void swap(int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void shitDown(int i) {
            while (true) {
                int l = i * 2 + 1, r = i * 2 + 2, mark = i;
                if (l < n && nums[mark] > nums[l]) {
                    mark = l;
                }
                if (r < n && nums[mark] > nums[r]) {
                    mark = r;
                }
                if (mark == i) return;
                swap(mark, i);
                i = mark;
            }
        }

        private int first() {
            return nums[0];
        }

        private void change(int num) {
            nums[0] = num;
            shitDown(0);
        }

    }

    public long totalCost(int[] costs, int k, int candidates) {
        long ans = 0;
        if (k + candidates * 2 > costs.length) {
            Arrays.sort(costs);
            for (int i = 0; i < costs.length; i++) {
                if (i < k) {
                    ans += costs[i];
                } else {
                    break;
                }
            }
            return ans;
        }
        Heap beginHeap = new Heap(Arrays.copyOfRange(costs, 0, candidates));
        Heap endHeap = new Heap(Arrays.copyOfRange(costs, costs.length - candidates, costs.length));
        int i = 0, j = 0;
        while (k-- > 0) {
            if (endHeap.first() < beginHeap.first()) {
                ans += endHeap.first();
                j++;
                endHeap.change(costs[costs.length - candidates - j]);
            } else {
                ans += beginHeap.first();
                beginHeap.change(costs[candidates + i]);
                i++;
            }
        }
        return ans;
    }

}
