package com.wairdell.leetcode.problems;

import java.util.Map;

/**
 * date   : 2024/4/27 20:48
 * desc   : 数字范围按位与 https://leetcode.cn/problems/bitwise-and-of-numbers-range
 */
public class BitwiseAndOfNumbersRange {

    public static void main(String[] args) {
        BitwiseAndOfNumbersRange range = new BitwiseAndOfNumbersRange();
//        System.out.println(range.rangeBitwiseAnd(1, 2147483647));
//        System.out.println(range.rangeBitwiseAnd(2147483647, 2147483647));
//        System.out.println(range.rangeBitwiseAnd(1073741824, 2147483647));
//        System.out.println(range.rangeBitwiseAnd(2147483646, 2147483647));
        System.out.println(range.rangeBitwiseAnd(1, 2));
    }

    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) return left;
        int and = left;
        int i = 1;
        while (and > 0 && i <= 32 && and <= (right - (1 << i))) {
            if ((and & (1 << i)) > 0) {
                and -= (1 << i);
            }
            i++;
        }
        return and;
    }

}
