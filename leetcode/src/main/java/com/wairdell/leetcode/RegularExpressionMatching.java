package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/6 17:45
 * desc   : 正则表达式匹配 https://leetcode.cn/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    /*public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }*//* else if (s.length() == 0) {
            return false;
        }*//* else if (p.length() == 0) {
            return false;
        }
        char charAt = p.charAt(0);
        if (p.length() == 1) {
            if (s.length() == 1) {
                return charAt == '.' || charAt == s.charAt(0);
            }
            return false;
        } else {
            if (p.charAt(1) != '*') {
                if (s.length() > 0 && (charAt == '.' || charAt == s.charAt(0))) {
                    return isMatch(s.substring(1), p.substring(1));
                } else {
                    return false;
                }
            } else {
                int len = 2;
                for (int i = 2; i + 1 < p.length(); i++) {
                    if (p.charAt(i) != p.charAt(0) || p.charAt(i + 1) != p.charAt(1)) {
                        break;
                    }
                    len += 2;
                }
                if (isMatch(s, p.substring(len))) {
                    return true;
                }
                for (int i = 0; i < s.length(); i++) {
                    if (charAt == '.' || s.charAt(i) == charAt) {
                        if (isMatch(s.substring(i + 1), p.substring(len))) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }*/

    public static void main(String[] args) {
        System.out.println("result false = " + new RegularExpressionMatching().isMatch("aa", "a"));
        System.out.println("result true = " + new RegularExpressionMatching().isMatch("aa", "a*"));
        System.out.println("result true = " + new RegularExpressionMatching().isMatch("ab", ".*"));
        System.out.println("result false = " + new RegularExpressionMatching().isMatch("abc", "a.b"));
        System.out.println("result true = " + new RegularExpressionMatching().isMatch("abc", "a.c"));
        System.out.println("result false = " + new RegularExpressionMatching().isMatch("aab", "c*b*a*"));
        System.out.println("result true = " + new RegularExpressionMatching().isMatch("aab", "c*a*b*"));
        System.out.println("result true = " + new RegularExpressionMatching().isMatch("a", "ab*"));
        System.out.println("result false = " + new RegularExpressionMatching().isMatch("a", ".*..a*"));
        System.out.println("result false = " + new RegularExpressionMatching().isMatch("bb", ".bab"));
        System.out.println("result false = " + new RegularExpressionMatching().isMatch("aaaaaaaaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*"));
    }

}
