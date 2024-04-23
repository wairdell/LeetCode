package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/21 11:57
 * desc   : 位1的个数 https://leetcode.cn/problems/number-of-1-bits/
 */
public class NumberOf1Bits {

    public static void main(String[] args) {
        NumberOf1Bits number = new NumberOf1Bits();
        System.out.println(number.hammingWeight(11));
        System.out.println(number.hammingWeight(128));
    }

    public int hammingWeight(int n) {
        int ans = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans++;
            }
            n = (n >> 1);
        }
        return ans;
    }

}
