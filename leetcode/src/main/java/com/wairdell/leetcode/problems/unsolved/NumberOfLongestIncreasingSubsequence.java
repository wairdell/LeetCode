package com.wairdell.leetcode.problems.unsolved;

/**
 * date   : 2024/5/7 16:04
 * desc   : 最长递增子序列的个数 https://leetcode.cn/problems/number-of-longest-increasing-subsequence
 */
public class NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence subsequence = new NumberOfLongestIncreasingSubsequence();
        System.out.println(subsequence.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }

    public int findNumberOfLIS(int[] nums) {
        int ans = 1;
        int cnt = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cnt++;
                if (cnt == max) {
                    ans++;
                } else if (cnt > max) {
                    max = cnt;
                    ans = 1;
                }
            } else {
                cnt = 1;
            }
        }
        return ans;
    }

}
