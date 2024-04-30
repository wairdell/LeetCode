package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/28 14:48
 * desc   : 找到冠军 I https://leetcode.cn/problems/find-champion-i
 */
public class FindChampionI {

    public static void main(String[] args) {
        System.out.println(new FindChampionI().findChampion(new int[][]{
                {0, 1},
                {0, 0}
        }));

        System.out.println(new FindChampionI().findChampion(new int[][]{
                {0, 0, 1},
                {1, 0, 1},
                {0, 0, 0}
        }));

        System.out.println(new FindChampionI().findChampion(new int[][]{
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 1, 0}
        }));
    }

    public int findChampion(int[][] grid) {
        int n = grid.length;
        int mx = 0;
        int mi = 0;
        for (int i = 0; i < grid.length; i++) {
            int k = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    k++;
                }
            }
            if (k * 2 > n) {
                return i;
            }
            if (k > mx) {
                mx = k;
                mi = i;
            }
        }
        return mi;
    }

}
