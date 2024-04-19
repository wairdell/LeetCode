package com.wairdell.leetcode.problems.novelty;

/**
 * author : fengqiao
 * date   : 2023/2/9 13:40
 * desc   : 4的幂 https://leetcode.cn/problems/power-of-four/
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int n) {
        // 4 % 3 == 1 ,
        // (4 + 4 * 3) % 3 == (4 % 3 + 3 * (4 % 3)) % 3 = (1 + 3 * 1) = 1;
        return (n & (n - 1)) == 0 && n % 3 == 1;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfFour().isPowerOfFour(4));
        System.out.println(new PowerOfFour().isPowerOfFour(16));
        System.out.println(new PowerOfFour().isPowerOfFour(32));
    }

}
