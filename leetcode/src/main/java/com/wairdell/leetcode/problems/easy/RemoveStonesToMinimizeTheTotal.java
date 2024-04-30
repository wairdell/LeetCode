package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/29 14:12
 * desc   : 移除石子使总数最小 https://leetcode.cn/problems/remove-stones-to-minimize-the-tota
 */
public class RemoveStonesToMinimizeTheTotal {

    public static void main(String[] args) {
        RemoveStonesToMinimizeTheTotal stones = new RemoveStonesToMinimizeTheTotal();
        System.out.println(stones.minStoneSum(new int[]{5, 4, 9}, 2));
        System.out.println(stones.minStoneSum(new int[]{4, 3, 6, 7}, 3));
    }

    private static class Heap {

        private int[] piles;
        private int[] nums;
        private int n;

        Heap(int[] piles) {
            this.piles = piles;
            this.nums = new int[piles.length];
            this.n = piles.length;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = i;
            }
            for (int i = (n - 2) / 2; i >= 0; i--) {
                shiftDown(i);
            }
        }

        private void swap(int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void shiftDown(int i) {
            while (true) {
                int l = i * 2 + 1, r = i * 2 + 2, mark = i;
                if (l < n && piles[nums[mark]] < piles[nums[l]]) {
                    mark = l;
                }
                if (r < n && piles[nums[mark]] < piles[nums[r]]) {
                    mark = r;
                }
                if (mark == i) return;
                swap(mark, i);
                i = mark;
            }
        }

        private int adjust(int cnt) {
            for (int i = 0; i < cnt; i++) {
                int top = nums[0];
                piles[top] -= piles[top] / 2;
                shiftDown(0);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += piles[i];
            }
            return ans;
        }

    }

    public int minStoneSum(int[] piles, int k) {
        return new Heap(piles).adjust(k);
    }


}
