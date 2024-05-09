package com.wairdell.leetcode.problems;

import java.util.Arrays;

/**
 * date   : 2024/5/9 14:22
 * desc   : 消灭怪物的最大数量 https://leetcode.cn/problems/eliminate-maximum-number-of-monsters
 */
public class EliminateMaximumNumberOfMonsters {

    public static void main(String[] args) {
        EliminateMaximumNumberOfMonsters monsters = new EliminateMaximumNumberOfMonsters();
        System.out.println(monsters.eliminateMaximum(new int[]{1, 3, 4}, new int[]{1, 1, 1}));
        System.out.println(monsters.eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}));
        System.out.println(monsters.eliminateMaximum(new int[]{3, 2, 4}, new int[]{5, 3, 2}));
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] arrivalTimes = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            arrivalTimes[i] = (dist[i] - 1) / speed[i] + 1;
        }
        Arrays.sort(arrivalTimes);
        for (int i = 0; i < dist.length; i++) {
            if (arrivalTimes[i] <= i) {
                return i;
            }
        }
        return arrivalTimes.length;
    }

}
