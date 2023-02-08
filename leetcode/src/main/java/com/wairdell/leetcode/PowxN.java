package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/8 10:32
 * desc   : Pow(x, n) https://leetcode.cn/problems/powx-n/
 */
public class PowxN {

    public double myPow(double x, int n) {
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / (pow(x, Integer.MAX_VALUE) * x);
            }
            return 1 / pow(x, -n);
        }
        return pow(x, n);
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }
        double subPow = pow(x, n / 2);
        return subPow * subPow * (n % 2 == 1 ? x : 1);
    }

    public static void main(String[] args) {
        System.out.println("result = " + new PowxN().myPow(2, 10));
        System.out.println("result = " + new PowxN().myPow(2.1, 3));
        System.out.println("result = " + new PowxN().myPow(2.00000, -2));
        System.out.println("result = " + new PowxN().myPow(2.00000, -2147483648));
    }

}
