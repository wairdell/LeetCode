package com.wairdell.leetcode.problems.easy;

/**
 * author : fengqiao
 * date   : 2023/2/1 16:59
 * desc   : 斐波那契数 https://leetcode.cn/problems/fibonacci-number/
 */
public class FibonacciNumber {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int forward2 = 1;
        int forward1 = 0;
        int temp;
        for (int i = 1; i < n; i++) {
            temp = forward1;
            forward1 = forward1 + forward2;
            forward2 = temp;
        }
        return forward1 + forward2;
    }

    public static void main(String[] args) {
        System.out.println("result" + new FibonacciNumber().fib(5));
    }

}
