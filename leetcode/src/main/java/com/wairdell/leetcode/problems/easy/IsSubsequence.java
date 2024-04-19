package com.wairdell.leetcode.problems.easy;

/**
 * author : fengqiao
 * date   : 2023/2/2 10:17
 * desc   : 判断子序列 https://leetcode.cn/problems/is-subsequence/
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new IsSubsequence().isSubsequence("axc", "ahbgdc"));
    }


}
