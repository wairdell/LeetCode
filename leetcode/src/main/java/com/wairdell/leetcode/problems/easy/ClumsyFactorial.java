package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/11 15:41
 * desc   : 笨阶乘 https://leetcode.cn/problems/clumsy-factorial
 */
public class ClumsyFactorial {

    public static void main(String[] args) {
        ClumsyFactorial factorial = new ClumsyFactorial();
        System.out.println(factorial.clumsy(4));
        System.out.println(factorial.clumsy(10));
    }

    public int clumsy(int n) {
        int ans = 0;
        for (int i = 0; i < n; i += 4) {
            int first = n - i;
            int second = first > 1 ? first - 1 : 1;
            float third = second > 1 ? second - 1 : 1;
            int operator = i == 0 ? 1 : -1;
            int result = (int) Math.floor(first * second / third) * operator;
            ans += result;
            if (third > 1) {
                ans += third - 1;
            }
        }
        return ans;
    }

}
