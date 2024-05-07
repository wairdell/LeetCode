package com.wairdell.leetcode.problems.algorithm.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * date   : 2024/5/7 13:48
 * desc   : 01 矩阵 https://leetcode.cn/problems/01-matrix
 */
public class Matrix01 {

    public static void main(String[] args) {
        Matrix01 matrix01 = new Matrix01();
        int[][] matrix = matrix01.updateMatrix(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0},
        });
        for (int[] col : matrix) {
            System.out.println(Arrays.toString(col));
        }

        System.out.println("-----------------------------------");
        matrix = matrix01.updateMatrix(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{1, 1, 1},
        });
        for (int[] col : matrix) {
            System.out.println(Arrays.toString(col));
        }
    }

    private static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        Set<Pair> set = new HashSet<>();
        for (int i = 0; i < ans.length; i++) {
            Arrays.fill(ans[i], -1);
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                if (mat[i][j] == 0) {
                    set.add(new Pair(i, j));
                    ans[i][j] = 0;
                }
            }
        }
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        while (!set.isEmpty()) {
            Set<Pair> nextSet = new HashSet<>();

            for (Pair pair : set) {
                for (int i = 0; i < dx.length; i++) {
                    int nextY = pair.y + dy[i];
                    int nextX = pair.x + dx[i];
                    if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m) {
                        if (ans[nextY][nextX] == -1) {
                            nextSet.add(new Pair(nextY, nextX));
                            ans[nextY][nextX] = ans[pair.y][pair.x] + 1;
                        }
                    }
                }
            }

            set = nextSet;
        }
        return ans;
    }

}
