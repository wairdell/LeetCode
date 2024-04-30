package com.wairdell.leetcode.problems.easy;

/**
 * author : fengqiao
 * date   : 2023/2/13 16:25
 * desc   : 买卖股票的最佳时机 II https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new BestTimeToBuyAndSellStockII().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("result = " + new BestTimeToBuyAndSellStockII().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println("result = " + new BestTimeToBuyAndSellStockII().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

}
