package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/2 17:00
 * desc   : 不同路径 https://leetcode.cn/problems/unique-paths/
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        int largestSide = Math.max(m, n);
        for (int i = 1; i < largestSide; i++) {
            if (i < m && i < n) {
                dp[i][i] = dp[i - 1][i] + dp[i][i - 1];
            }
            if (i < m) {
                for (int j = i; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j -1];
                }
            }
            if (i < n) {
                for (int j = i; j < m; j++) {
                    dp[j][i] = dp[j - 1][i] + dp[j][i - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 3));
    }

}
