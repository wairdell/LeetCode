package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/2 17:30
 * desc   : 不同路径 II https://leetcode.cn/problems/unique-paths-ii/
 */
public class UniquePathsII {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        int largestSide = Math.max(m, n);
        for (int i = 1; i < largestSide; i++) {
            if (i < m && i < n) {
                if (obstacleGrid[i][i] == 0) {
                    dp[i][i] = dp[i - 1][i] + dp[i][i - 1];
                }
            }
            if (i < m) {
                for (int j = i; j < n; j++) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j -1];
                    }
                }
            }
            if (i < n) {
                for (int j = i; j < m; j++) {
                    if (obstacleGrid[j][i] == 0) {
                        dp[j][i] = dp[j - 1][i] + dp[j][i - 1];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        /*int[][] input = new int[][]{
                new int[]{0,0,0},
                new int[]{0,1,0},
                new int[]{0,0,0}
        };*/
        /*int[][] input = new int[][]{
                new int[]{0,1},
                new int[]{0,0}
        };*/
        /*int[][] input = new int[][]{
                new int[]{0,0},
                new int[]{0,1}
        };*/
       /* int[][] input = new int[][]{
                new int[]{0, 1},
        };*/
        int[][] input = new int[][]{
                new int[]{1, 0},
        };
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(input));
    }

}
