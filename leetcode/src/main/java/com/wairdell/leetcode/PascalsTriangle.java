package com.wairdell.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/1 16:36
 * desc   : 杨辉三角 https://leetcode.cn/problems/pascals-triangle/
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> lastRow = result.get(i - 1);
                    row.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            result.add(row);
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println("result" + new PascalsTriangle().generate(8));
    }

}
