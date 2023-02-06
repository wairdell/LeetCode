package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/2 18:21
 * desc   : 搜索二维矩阵 https://leetcode.cn/problems/search-a-2d-matrix/
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int findIndex = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]) {
                findIndex = i;
                break;
            } else if (target < matrix[i][0]) {
                return false;
            }
        }
        if (findIndex < 0) {
            return false;
        }
        for (int j = 0; j < matrix[findIndex].length; j++) {
            if (matrix[findIndex][j] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 60},
        };
        int target = 3;
        /*int[][] input = new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 60},
        };
        int target = 13;*/
        System.out.println("result = " + new SearchA2DMatrix().searchMatrix(input, target));
    }

}
