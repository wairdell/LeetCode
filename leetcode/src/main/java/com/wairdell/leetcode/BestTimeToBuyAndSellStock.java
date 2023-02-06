package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/2 10:12
 * desc   : 买卖股票的最佳时机 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            result = Math.max(result, price - min);
            min = Math.min(min, price);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println("result = " + new BestTimeToBuyAndSellStock().maxProfit(prices));
    }

}
