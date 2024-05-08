package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * date   : 2024/5/8 17:26
 * desc   : 杨辉三角 II https://leetcode.cn/problems/pascals-triangle-ii
 */
public class PascalsTriangleII {

    public static void main(String[] args) {
        PascalsTriangleII triangleII = new PascalsTriangleII();
        System.out.println(triangleII.getRow(4));
    }

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return Collections.singletonList(1);
        int[] ans;
        int[] previous = new int[1];
        previous[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            ans = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    ans[j] = 1;
                } else {
                    ans[j] = previous[j - 1] + previous[j];
                }
            }
            previous = ans;
        }

        return  Arrays.stream(previous).boxed().collect(Collectors.toList());
       /* List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle.get(rowIndex);*/
    }

}
