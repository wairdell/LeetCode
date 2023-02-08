package com.wairdell.leetcode;


/**
 * author : fengqiao
 * date   : 2023/2/7 15:25
 * desc   : 地下城游戏 https://leetcode.cn/problems/dungeon-game/
 */
public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][n] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[m][i] = Integer.MAX_VALUE;
        }
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, min - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = new int[][]{new int[]{-2, -3, 3}, new int[]{-5, -10, 1}, new int[]{10, 30, -5}};

        System.out.println("result = " + new DungeonGame().calculateMinimumHP(dungeon));
    }

}
