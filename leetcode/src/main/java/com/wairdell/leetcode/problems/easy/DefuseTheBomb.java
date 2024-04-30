package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;

/**
 * date   : 2024/5/6 10:03
 * desc   : 拆炸弹 https://leetcode.cn/problems/defuse-the-bomb
 */
public class DefuseTheBomb {

    public static void main(String[] args) {
        DefuseTheBomb bomb = new DefuseTheBomb();
        System.out.println(Arrays.toString(bomb.decrypt(new int[]{5, 7, 1, 4}, 3)));
        System.out.println(Arrays.toString(bomb.decrypt(new int[]{2, 4, 9, 3}, -2)));
    }

    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if (k > 0) {
            int sum = 0;
            for (int i = 1; i <= k; i++) {
                sum += code[i % code.length];
            }
            ans[0] = sum;
            for (int i = 1; i < code.length; i++) {
                sum -= code[i];
                sum += code[(i + k) % code.length];
                ans[i] = sum;
            }
        } else if (k < 0) {
            int sum = 0;
            for (int i = 0; i < Math.abs(k); i++) {
                sum += code[code.length - 1 - i];
            }
            ans[0] = sum;
            for (int i = code.length - 1; i > 0; i--) {
                sum -= code[i];
                sum += code[(i + k + code.length) % code.length];
                ans[i] = sum;
            }
        }
        return ans;
    }

}
