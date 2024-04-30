package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/28 13:56
 * desc   : 阶乘后的零 https://leetcode.cn/problems/factorial-trailing-zeroes
 */
public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        FactorialTrailingZeroes zeroes = new FactorialTrailingZeroes();
        System.out.println(zeroes.trailingZeroes(3000)); //748
        System.out.println(zeroes.trailingZeroes(80000)); //19999
        System.out.println(zeroes.trailingZeroes(405000)); //101248
    }

    public int trailingZeroes(int n) {
        int zeroCnt = 0;
        int fiveCnt = 0;
        for (int i = 5; i <= n; i += 5) {
            int num = i;
            while (num % 10 == 0) {
                zeroCnt++;
                num /= 10;
            }
            while (num % 5 == 0) {
                fiveCnt++;
                num /= 5;
            }
        }
        return zeroCnt + fiveCnt;
    }

}
