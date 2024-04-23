package com.wairdell.leetcode.problems.unsolved;

import java.util.HashMap;
import java.util.Map;

/**
 * author : fengqiao
 * date   : 2023/2/3 14:45
 * desc   : 最大矩形 https://leetcode.cn/problems/maximal-rectangle/
 */
public class MaximalRectangle {


    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        Map<String, Integer> horizontal = new HashMap<>();
        Map<String, Integer> vertical = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            int findPoint = -1;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    if (findPoint < 0) {
                        findPoint = i;
                    }
                    if (j == matrix[i].length - 1 || matrix[i][j + 1] == 0) {
                        horizontal.put(i + "," + j, j - findPoint + 1);
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int j = 0;
            for (; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    break;
                }
            }
            if (j == matrix[i].length) {
//                max = Math.max()
            }

        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(new MaximalRectangle().maximalRectangle());
    }

}
