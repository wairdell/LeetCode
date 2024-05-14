package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/14 18:30
 * desc   : 计算应缴税款总额 https://leetcode.cn/problems/calculate-amount-paid-in-taxes
 */
public class CalculateAmountPaidInTaxes {

    public static void main(String[] args) {
        CalculateAmountPaidInTaxes taxes = new CalculateAmountPaidInTaxes();
        System.out.println(taxes.calculateTax(new int[][]{new int[]{3, 50}, new int[]{7, 10}, new int[]{12, 25}}, 10));
    }

    public double calculateTax(int[][] brackets, int income) {
        double ans = 0d;
        for (int i = 0; i < brackets.length; i++) {
            int upper = brackets[i][0];
            int percent = brackets[i][1];
            int money = Math.min(income, upper - (i > 0 ? brackets[i - 1][0] : 0));
            double free = money * percent / 100d;
            ans += free;
            income -= money;
            if (income <= 0) break;
        }
        return ans;
    }

}
