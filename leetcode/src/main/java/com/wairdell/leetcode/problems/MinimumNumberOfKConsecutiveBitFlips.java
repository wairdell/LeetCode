package com.wairdell.leetcode.problems;

/**
 * date   : 2024/4/21 10:25
 * desc   : K 连续位的最小翻转次数 https://leetcode.cn/problems/minimum-number-of-k-consecutive-bit-flips
 */
public class MinimumNumberOfKConsecutiveBitFlips {

    public int minKBitFlips(int[] nums, int k) {
        int[] op = new int[nums.length + 1];
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= op[i];
            if ((sum ^ nums[i]) == 0) {
                if (i + k > nums.length) {
                    return -1;
                }
                op[i + k] ^= 1;
                sum ^= 1;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumNumberOfKConsecutiveBitFlips flips = new MinimumNumberOfKConsecutiveBitFlips();
        System.out.println(flips.minKBitFlips(new int[]{0, 1, 0}, 1));
        System.out.println(flips.minKBitFlips(new int[]{1, 1, 0}, 2));
        System.out.println(flips.minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3));
    }

}
