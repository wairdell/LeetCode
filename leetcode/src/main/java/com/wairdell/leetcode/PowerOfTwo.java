package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/9 13:36
 * desc   : 2 的幂 https://leetcode.cn/problems/power-of-two/
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        //2的N次方-1会的一个二进制位上全是1的数 如 1000000 - 1 = 0111111
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(2));
        System.out.println(new PowerOfTwo().isPowerOfTwo(1));
    }

}
