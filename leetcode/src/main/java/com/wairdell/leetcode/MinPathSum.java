package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/1 15:35
 * desc   : 最小路径和 https://leetcode.cn/problems/minimum-path-sum/
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int gridSize = grid.length;
        int colSize = grid[0].length;
        //int[][] dp = new int[gridSize][colSize];
        //dp[0][0] = grid[0][0];
        for (int i = 1; i < gridSize; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }
        for (int i = 1; i < colSize; i++) {
            grid[0][i] = grid[0][i] + grid[0][i - 1];
        }
        int t = Math.max(gridSize, colSize);
        for (int i = 1; i < t; i++) {
            if (i < gridSize && i < colSize) {
                grid[i][i] = grid[i][i] + (Math.min(grid[i - 1][i], grid[i][i - 1]));
            }
            if (i < gridSize) {
                for (int j = i + 1; j < colSize; j++) {
                    grid[i][j] = grid[i][j] + (Math.min(grid[i - 1][j], grid[i][j - 1]));
                }
            }
            if (i < colSize) {
                for (int j = i + 1; j < gridSize; j++) {
                    grid[j][i] = grid[j][i] + (Math.min(grid[j - 1][i], grid[j][i - 1]));
                }
            }
        }
        return grid[gridSize - 1][colSize - 1];
    }

    public static void main(String[] args) {
       /* int[][] grid = new int[3][3];
        grid[0] = new int[]{1,3,1};
        grid[1] = new int[]{1,5,1};
        grid[2] = new int[]{4,2,1};*/
        int[][] grid = new int[2][3];
        grid[0] = new int[]{1,2,3};
        grid[1] = new int[]{4,5,6};
        System.out.println(new MinPathSum().minPathSum(grid));
    }

}
