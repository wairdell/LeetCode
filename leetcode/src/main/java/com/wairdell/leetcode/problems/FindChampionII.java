package com.wairdell.leetcode.problems;

/**
 * date   : 2024/4/28 15:32
 * desc   : 找到冠军 II https://leetcode.cn/problems/find-champion-ii
 */
public class FindChampionII {

    public static void main(String[] args) {
        FindChampionII ii = new FindChampionII();
        System.out.println(ii.findChampion(3, new int[][]{
                {0, 1},
                {1, 2}
        }));

        System.out.println(ii.findChampion(4, new int[][]{
                {0, 2},
                {1, 3},
                {1, 2}
        }));
    }

    public int findChampion(int n, int[][] edges) {
        int[] lose = new int[n];
        for (int[] edge : edges) {
            lose[edge[1]]++;
        }
        int win = -1;
        for (int i = 0; i < lose.length; i++) {
            if (lose[i] == 0) {
                if (win == -1) {
                    win = i;
                } else {
                    return -1;
                }
            }
        }
        return win;
    }



}
