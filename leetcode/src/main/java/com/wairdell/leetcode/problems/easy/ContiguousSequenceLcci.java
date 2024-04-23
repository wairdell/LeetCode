package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/21 11:28
 * desc   : 面试题 16.17. 连续数列 https://leetcode.cn/problems/contiguous-sequence-lcc
 */
public class ContiguousSequenceLcci {

    public static void main(String[] args) {
        ContiguousSequenceLcci lcci = new ContiguousSequenceLcci();
        System.out.println(lcci.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int previous = nums[0];
        int max = previous;
        for (int i = 1; i < nums.length; i++) {
            if (previous > 0) {
                max = Math.max(max, previous + nums[i]);
                previous = previous + nums[i];
            } else {
                max = Math.max(max, nums[i]);
                previous = nums[i];
            }
        }
        return max;
    }

}
