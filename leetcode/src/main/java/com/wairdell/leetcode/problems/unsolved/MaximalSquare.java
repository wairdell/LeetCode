package com.wairdell.leetcode.problems.unsolved;

/**
 * date   : 2024/4/27 21:28
 * desc   : 最大正方形 https://leetcode.cn/problems/maximal-square6
 */
public class MaximalSquare {


    public static void main(String[] args) {
        MaximalSquare square = new MaximalSquare();
        System.out.println(square.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] h = new int[n][m];
        int[][] v = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int t = j;
                while (t < m && matrix[i][t] == '1') {
                    t++;
                }
                if (t != j) {
                    for (int k = j; k < t; k++) {
                        h[i][k] = t - j;
                    }
                    j = t;
                }
            }
        }


        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int t = j;
                while (t < n && matrix[t][j] == '1') {
                    t++;
                }
                if (t != j) {
                    for (int k = j; k < t; k++) {
                        v[k][j] = t - i;
                    }
                    i = t;
                }
            }
        }
        return 0;
    }


}
