package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/7 13:43
 * desc   : 编辑距离 https://leetcode.cn/problems/edit-distance/
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int j = 1; j < word2.length(); j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for (int i = 1; i < word1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + (word1.charAt(i) == word2.charAt(j) ? 0 : 1);
            }
        }
        return dp[word1.length() - 1][word2.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("horse", "ros"));
        System.out.println(new EditDistance().minDistance("intention", "execution"));
    }

}
