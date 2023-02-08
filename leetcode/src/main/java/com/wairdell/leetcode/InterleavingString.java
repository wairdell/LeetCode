package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/7 13:59
 * desc   : 交错字符串 https://leetcode.cn/problems/interleaving-string/
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return dp[m][n];
    }

    /*public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleave(s1, s2, s3, 0, 0, 0);
    }

    public boolean isInterleave(String s1, String s2, String s3, int s1i, int s2i, int s3i) {
        if (s3i == s3.length()) {
            return s1i == s1.length() && s2i == s2.length();
        }
        if (s1i < s1.length() && s1.charAt(s1i) == s3.charAt(s3i) && isInterleave(s1, s2, s3, s1i + 1, s2i, s3i + 1)) {
            return true;
        }
        if (s2i < s2.length() && s2.charAt(s2i) == s3.charAt(s3i) && isInterleave(s1, s2, s3, s1i, s2i + 1, s3i + 1)) {
            return true;
        }
        return false;
    }*/

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(new InterleavingString().isInterleave("", "", ""));
    }

}
