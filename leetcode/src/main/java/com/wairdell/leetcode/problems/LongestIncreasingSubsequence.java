package com.wairdell.leetcode.problems;

/**
 * date   : 2024/5/9 16:48
 * desc   : 最长递增子序列 https://leetcode.cn/problems/longest-increasing-subsequence
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();
        System.out.println(subsequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(subsequence.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(subsequence.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
//                if (nums[j] > nums[i]) break;
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }

}
