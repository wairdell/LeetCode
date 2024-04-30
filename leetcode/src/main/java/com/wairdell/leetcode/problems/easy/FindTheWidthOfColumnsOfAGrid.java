package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;

/**
 * date   : 2024/4/27 15:10
 * desc   : 查询网格图中每一列的宽度 https://leetcode.cn/problems/find-the-width-of-columns-of-a-grid
 */
public class FindTheWidthOfColumnsOfAGrid {

    public static void main(String[] args) {
        FindTheWidthOfColumnsOfAGrid width = new FindTheWidthOfColumnsOfAGrid();
        /*System.out.println(Arrays.toString(width.findColumnWidth(new int[][]{
                {1},
                {22},
                {333}
        })));

        System.out.println(Arrays.toString(width.findColumnWidth(new int[][]{
                {-15,1,3},
                {15,7,12},
                {5,6,-2}
        })));*/

        System.out.println(Arrays.toString(width.findColumnWidth(new int[][]{
                {0},
        })));
    }

    public int[] findColumnWidth(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int max = 1;
            for (int j = 0; j < n; j++) {
                int num = grid[j][i];
                if (num == 0) continue;
                int size = (int) Math.log10(Math.abs(num)) + 1;
                if (num <= 0) size++;
                max = Math.max(size, max);
            }
            ans[i] = max;
        }
        return ans;
    }

}
