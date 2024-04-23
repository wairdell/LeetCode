package com.wairdell.leetcode.problems;

/**
 * date   : 2024/4/23 17:56
 * desc   : 爱生气的书店老板 https://leetcode.cn/problems/grumpy-bookstore-owner
 */
public class GrumpyBookstoreOwner {

    public static void main(String[] args) {
        GrumpyBookstoreOwner owner = new GrumpyBookstoreOwner();
        System.out.println(owner.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int max = 0;
        int dp[][] = new int[customers.length][2];
        for (int i = 0; i < customers.length; i++) {
            if (i > 0) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
            if (grumpy[i] == 0) {
                dp[i][0] += customers[i];
            }
            dp[i][1] += customers[i];
            if (i + 1 - minutes >= 0) {
                int widget = dp[i][1] - dp[i][0];
                if (i - minutes >= 0) {
                    widget -= (dp[i - minutes][1] - dp[i - minutes][0]);
                }
                max = Math.max(widget, max);
            }
        }
        return dp[customers.length - 1][0] + max;
    }

}
