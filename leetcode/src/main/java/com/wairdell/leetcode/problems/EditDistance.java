package com.wairdell.leetcode.problems;

/**
 * author : fengqiao
 * date   : 2023/2/7 13:43
 * desc   : 编辑距离 https://leetcode.cn/problems/edit-distance/
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //为增加操作时，将word1[i + 1]位置添加word2[j], 次数为 增加操作1次+ dp[i][j - 1]需要的操作
                    //为删除操作时，将word1[i] 位置移除，次数为 删除操作1次 + dp[i - 1][j] 需要的操作
                    //为替换操作时, 将word[i] 位置替换，次数为 替换操作1次 + dp[i - 1][j - 1] 需要的操作
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("horse", "ros"));
        System.out.println(new EditDistance().minDistance("intention", "execution"));
    }

}
