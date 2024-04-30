package com.wairdell.leetcode.problems.algorithm.dfs;

/**
 * author : fengqiao
 * date   : 2023/2/7 18:22
 * desc   : 目标和 https://leetcode.cn/problems/Target-Sum/description/
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        return calc(nums, target, 0, 0);
    }

    public int calc(int[] nums, int target, int i, int sum) {
        if (i == nums.length) {
            if (sum == target) return 1;
            return 0;
        }
        return calc(nums, target, i + 1, sum + nums[i]) + calc(nums, target, i + 1, sum - nums[i]);
    }

    public static void main(String[] args) {
        System.out.println("result = " + new TargetSum().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println("result = " + new TargetSum().findTargetSumWays(new int[]{1}, 1));
    }

}
