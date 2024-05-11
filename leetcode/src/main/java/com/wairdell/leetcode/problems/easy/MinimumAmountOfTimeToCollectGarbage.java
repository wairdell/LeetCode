package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/11 15:21
 * desc   : 收集垃圾的最少总时间 https://leetcode.cn/problems/minimum-amount-of-time-to-collect-garbage
 */
public class MinimumAmountOfTimeToCollectGarbage {

    public static void main(String[] args) {
        MinimumAmountOfTimeToCollectGarbage garbage = new MinimumAmountOfTimeToCollectGarbage();
        System.out.println(garbage.garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}));
        System.out.println(garbage.garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10}));
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        //M P G
        int[] total = new int[travel.length];
        total[0] = travel[0];
        for (int i = 1; i < travel.length; i++) {
            total[i] = travel[i] + total[i - 1];
        }
        int m = 0, p = 0, g = 0;
        int ans = 0;
        for (int i = 0; i < garbage.length; i++) {
            String s = garbage[i];
            ans += s.length();
            if (i > 0) {
                if (s.indexOf('M') >= 0) {
                    m = total[i - 1];
                }
                if (s.indexOf('P') >= 0) {
                    p = total[i - 1];
                }
                if (s.indexOf('G') >= 0) {
                    g = total[i - 1];
                }
            }
        }
        return ans + m + p + g;
    }

}
