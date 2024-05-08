package com.wairdell.leetcode.problems;

/**
 * date   : 2024/5/8 18:00
 * desc   : N 皇后 II https://leetcode.cn/problems/n-queens-ii
 */
public class NQueensII {

    public static void main(String[] args) {
        NQueensII queensII = new NQueensII();
        System.out.println(queensII.totalNQueens(4));
    }

    public int totalNQueens(int n) {
        return solve(n, 0, new boolean[n], new boolean[n * 2], new boolean[n * 2]);
    }

    public int solve(int n, int i, boolean[] row, boolean[] skim, boolean[] suppress) {
        if (i == n) {
            return 1;
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            int sk = i - j + n;
            int su = i + j;
            if (row[j] || skim[sk] || suppress[su]) continue;
            row[j] = true;
            skim[sk] = true;
            suppress[su] = true;
            ans += solve(n, i + 1, row, skim, suppress);
            row[j] = false;
            skim[sk] = false;
            suppress[su] = false;
        }
        return ans;
    }

}
