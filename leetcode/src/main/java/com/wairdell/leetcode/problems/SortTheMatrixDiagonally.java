package com.wairdell.leetcode.problems;

import java.util.Arrays;

/**
 * date   : 2024/4/29 9:37
 * desc   : 将矩阵按对角线排序 https://leetcode.cn/problems/sort-the-matrix-diagonally
 */
public class SortTheMatrixDiagonally {

    public static void main(String[] args) {
        SortTheMatrixDiagonally diagonally = new SortTheMatrixDiagonally();
        int[][] ret = diagonally.diagonalSort(new int[][]{
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        });
        for (int i = 0; i < ret.length; i++) {
            System.out.println(Arrays.toString(ret[i]));
        }
    }

    private void swap(int[][] max, int y, int x, int y1, int x1) {
        int temp = max[y][x];
        max[y][x] = max[y1][x1];
        max[y1][x1] = temp;
    }

    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length, m = mat[0].length;
//        int size = m + n - 1;
        int l = -n + 1;
        int r = m - 1;
        for (int i = l; i <= r; i++) {
            int dx = 0, dy = 0;
            if (i < 0) {
                dy = -i;
            } else if (i > 0) {
                dx = i;
            }
            int x = dx, y = dy;
            int size = Math.min(n - y, m - x);
            int k = 0;
            while (k < size) {
                int q = 1;
                int cy = y + k;
                int cx = x + k;
                while (cx + q < m && cy + q < n) {
                    if (mat[cy][cx] > mat[cy + q][cx + q]) {
                        swap(mat, cy, cx, cy + q, cx + q);
                    }
                    q++;
                }
                k++;
            }
        }
        return mat;
    }


}
