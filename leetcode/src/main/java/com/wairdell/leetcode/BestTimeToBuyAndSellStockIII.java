package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/13 16:25
 * desc   : 买卖股票的最佳时机 IV https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        if (prices.length == 2) {
            return Math.max(0, prices[1] - prices[0]);
        }
        //dp[i][0] 代表一笔交易
        //dp[i][1] 代表两笔交易
        int[][] dp = new int[prices.length][2];
        dp[1][0] = Math.max(prices[1] - prices[0], 0);
        dp[1][1] = Math.max(prices[1] - prices[0], 0);
        int min = Math.min(prices[0], prices[1]);
        int max = dp[0][0] - prices[1];
        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] - min);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + max);
            /*dp[i][0] = dp[i - 1][0];
            for (int j = 0; j < i; j++) {
                dp[i][0] = Math.max(dp[i][0], prices[i] - prices[j]);
            }
            dp[i][1] = dp[i - 1][1];
            for (int j = 1; j < i; j++) {
                //prices[i] + dp[j - 1][0] - prices[j];
                dp[i][1] = Math.max(dp[i][1], dp[j - 1][0] + (prices[i] - prices[j]));
            }*/
            dp[i][1] = Math.max(dp[i][0], dp[i][1]);
            min = Math.min(prices[i], min);
            max = Math.max(dp[i - 1][0] - prices[i], max);
        }
        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
        System.out.println("result 7 = " + new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("result 4 = " + new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println("result 0 = " + new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println("result 6 = " + new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println("result 2 = " + new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{3, 4, 5}));
        System.out.println("result 19 = " + new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{14, 9, 10, 12, 4, 8, 1, 16}))
        ;
    }

}
