package com.wairdell.leetcode.problems.algorithm.dp;

import java.util.Arrays;

/**
 * date   : 2024/4/24 13:44
 * desc   : 组合总和 Ⅳ https://leetcode.cn/problems/combination-sum-iv
 */
public class CombinationSumIv {

    public static void main(String[] args) {
        CombinationSumIv sumIv = new CombinationSumIv();
        System.out.println(sumIv.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(sumIv.combinationSum4(new int[]{9}, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i) break;
                if (dp[i - num] > 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

}
