package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/7 11:27
 * desc   : 最大连续 1 的个数 https://leetcode.cn/problems/max-consecutive-ones
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        MaxConsecutiveOnes ones = new MaxConsecutiveOnes();
        System.out.println(ones.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println(ones.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int j = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                j++;
                max = Math.max(max, j);
            } else {
                j = 0;
            }
        }
        return max;
    }

}
