package com.wairdell.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/23 17:59
 * desc   : N 皇后 https://leetcode.cn/problems/n-queens/
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        int[] cols = new int[n];
        int[] skim = new int[n];
        int[] na = new int[n];
        List<int[]> searchResult = new ArrayList<>();
        search(0, n, cols, skim, na, searchResult);
        List<List<String>> result = new ArrayList<>(searchResult.size());
        for (int[] ints : searchResult) {
            ArrayList<String> answer = new ArrayList<>();
            for (int p : ints) {
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < p; i++) line.append(".");
                line.append("Q");
                for (int i = p + 1; i < n; i++) line.append(".");
                answer.add(line.toString());
            }
            result.add(answer);
        }
        return result;
    }

    private void search(int i, int n, int[] cols, int[] skim, int[] na, List<int[]> searchResult) {
        if (i == n) {
            searchResult.add(Arrays.copyOf(cols, cols.length));
        }
        out:
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < i; k++) {
                if (cols[k] == j || skim[k] == i - j || na[k] == i + j) continue out;
            }
            cols[i] = j;
            skim[i] = i - j;
            na[i] = i + j;
            search(i + 1, n, cols, skim, na, searchResult);
        }
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4).toString());
    }

}
