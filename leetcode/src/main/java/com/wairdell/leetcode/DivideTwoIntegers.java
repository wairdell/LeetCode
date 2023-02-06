package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/3 16:00
 * desc   : 两数相除 https://leetcode.cn/problems/divide-two-integers/
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        } else if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            return dividend == -2147483648 ? 2147483647 : -dividend;
        }
        int result = 0;
        boolean isSignSame = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while ((dividend - divisor) >= 0) {
            dividend -= divisor;
            if (result == 2147483647) {
                return -2147483648;
            }
            result++;
            if (result >= 2147483647 && isSignSame) {
                return 2147483647;
            }
        }
        return result * (isSignSame ? 1 : -1);
    }

    public static void main(String[] args) {
//        System.out.println("result = " + new DivideTwoIntegers().divide(10, 3));
//        System.out.println("result = " + new DivideTwoIntegers().divide(10, -3));
//        System.out.println("result = " + new DivideTwoIntegers().divide(7, -3));
//        System.out.println("result = " + new DivideTwoIntegers().divide(1, 1));
//        System.out.println("result = " + new DivideTwoIntegers().divide(-2147483648, -1));
//        System.out.println("result = " + new DivideTwoIntegers().divide(7, -3));
        System.out.println("result = " + new DivideTwoIntegers().divide(
                -2147483648, -1));
    }

}
