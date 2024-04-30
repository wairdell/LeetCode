package com.wairdell.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * date   : 2024/4/28 15:02
 * desc   : 螺旋矩阵 https://leetcode.cn/problems/spiral-matrix
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix matrix = new SpiralMatrix();
        /*System.out.println(matrix.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));

        System.out.println(matrix.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }));*/

        System.out.println(matrix.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        }));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        int t = 0;
        int r = m - 1;
        int b = n - 1;
        int x = 0;
        int y = 0;
        int dx = 1;
        int dy = 0;
        ans.add(matrix[0][0]);
        while (ans.size() < n * m) {
            if (dx + x > r) {
                dx = 0;
                dy = 1;
                t++;
            } else if (dy + y > b) {
                dx = -1;
                dy = 0;
                r--;
            } else if (dx + x < l) {
                dx = 0;
                dy = -1;
                b--;
            } else if (dy + y < t) {
                dx = 1;
                dy = 0;
                l++;
            }
            x = x + dx;
            y = y + dy;
            ans.add(matrix[y][x]);
        }
        return ans;
    }

}
