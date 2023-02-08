package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/7 11:34
 * desc   : 通配符匹配 https://leetcode.cn/problems/wildcard-matching/
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                 if (p.charAt(j - 1) == '*') {
                     dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    if (isMatch(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean isMatch(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        return p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1);
    }


    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("aa", "a"));
        System.out.println(new WildcardMatching().isMatch("aa", "*"));
        System.out.println(new WildcardMatching().isMatch("cb", "?a"));
        System.out.println(new WildcardMatching().isMatch("adceb", "*a*b"));
        System.out.println(new WildcardMatching().isMatch("acdcb", "a*c?b"));
    }

}
