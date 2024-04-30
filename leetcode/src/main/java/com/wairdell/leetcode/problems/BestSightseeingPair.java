package com.wairdell.leetcode.problems;

/**
 * date   : 2024/4/28 10:57
 * desc   : 最佳观光组合 https://leetcode.cn/problems/best-sightseeing-pair
 */
public class BestSightseeingPair {

    public static void main(String[] args) {
        BestSightseeingPair pair = new BestSightseeingPair();
        System.out.println(pair.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
        System.out.println(pair.maxScoreSightseeingPair(new int[]{1, 2}));
        System.out.println(pair.maxScoreSightseeingPair(new int[]{3, 7, 2, 3}));
        System.out.println(pair.maxScoreSightseeingPair(new int[]{3, 2, 7, 3}));
        System.out.println(pair.maxScoreSightseeingPair(new int[]{30, 13, 28, 32, 16, 8, 11, 78, 83, 5, 22, 93, 61, 60, 100, 8, 6, 48, 87, 43, 41, 86, 93, 5, 19, 29, 59, 31, 7, 51, 99, 47, 40, 24, 20, 98, 41, 42, 81, 92, 55, 85, 51, 92, 84, 21, 84, 92, 1, 73, 93, 51, 44, 27, 23, 54, 32, 57, 60, 9, 69, 14, 28, 86, 15, 92, 47, 63, 12, 99, 54, 6, 16, 52, 28, 86, 38, 73, 16, 52, 37, 30, 84, 81, 46, 97, 84, 17, 21, 14, 52, 19, 74, 20, 20, 56, 89, 7, 34, 21}));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int mx = values[0];
        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans, values[i] - i + mx);
            mx = Math.max(mx, values[i] + i);
        }
        return ans;
    }
}

