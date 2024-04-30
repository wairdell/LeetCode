package com.wairdell.leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * date   : 2024/4/29 15:13
 * desc   : 股票价格波动 https://leetcode.cn/problems/stock-price-fluctuation
 */
public class StockPriceFluctuation {

    public static void main(String[] args) {
        StockPrice price = new StockPrice();
        price.update(1, 10);
        price.update(2, 5);
        System.out.println(price.current());
        System.out.println(price.maximum());
        price.update(1, 3);
        System.out.println(price.maximum());
        price.update(4, 2);
        System.out.println(price.minimum());
        System.out.println(price.maximum());
    }

    static class StockPrice {

        private Map<Integer, Integer> timestampMap = new HashMap<>();
        private TreeMap<Integer, Integer> priceMap = new TreeMap<>();

        private int maxTimestamp = 0;

        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            maxTimestamp = Math.max(timestamp, maxTimestamp);
            int prePrice = timestampMap.getOrDefault(timestamp, 0);
            timestampMap.put(timestamp, price);
            if (prePrice > 0) {
                Integer priceCnt = priceMap.getOrDefault(prePrice, 1);
                priceCnt--;
                if (priceCnt <= 0) {
                    priceMap.remove(prePrice);
                } else {
                    priceMap.put(prePrice, priceCnt);
                }
            }
            priceMap.put(price, priceMap.getOrDefault(price, 0) + 1);
        }

        public int current() {
            return timestampMap.get(maxTimestamp);
        }

        public int maximum() {
            return priceMap.lastKey();
        }

        public int minimum() {
            return priceMap.firstKey();
        }
    }

}
