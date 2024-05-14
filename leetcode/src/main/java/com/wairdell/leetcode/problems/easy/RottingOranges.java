package com.wairdell.leetcode.problems.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * date   : 2024/5/13 9:36
 * desc   : 腐烂的橘子 https://leetcode.cn/problems/rotting-oranges
 */
public class RottingOranges {

    public static void main(String[] args) {
        RottingOranges oranges = new RottingOranges();
//        System.out.println(oranges.orangesRotting(new int[][]{new int[]{2, 1, 1}, new int[]{1, 1, 0}, new int[]{0, 1, 1}}));
//        System.out.println(oranges.orangesRotting(new int[][]{new int[]{2, 1, 1}, new int[]{0, 1, 1}, new int[]{1, 0, 1}}));
//        System.out.println(oranges.orangesRotting(new int[][]{new int[]{0, 2}}));
        System.out.println(oranges.orangesRotting(new int[][]{new int[]{2, 2, 2, 1, 1}}));
    }

    private int[] dx = new int[]{0, 0, 1, -1};
    private int[] dy = new int[]{1, -1, 0, 0};

    public int orangesRotting(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> fresh = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int pos = i * m + j;
                if (grid[i][j] == 2) {
                    set.add(pos);
                } else if (grid[i][j] == 1) {
                    fresh.add(pos);
                }
            }
        }
        int ans = 0;
        while (!set.isEmpty()) {
            Set<Integer> nextSet = new HashSet<>();

            for (Integer pos : set) {
                int x = pos / m;
                int y = pos % m;
                for (int i = 0; i < dx.length; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                    int nextPos = nextX * m + nextY;
                    if (grid[nextX][nextY] == 1 && fresh.contains(nextPos)) {
                        nextSet.add(nextPos);
                        fresh.remove(nextPos);
                    }
                }
            }

            set = nextSet;
            if (!nextSet.isEmpty()) ans++;
        }
        return fresh.isEmpty() ? ans : -1;
    }

}
