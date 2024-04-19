package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;

/**
 * author : fengqiao
 * date   : 2023/3/16 9:57
 * desc   : 加一 https://leetcode.cn/problems/Plus-One/description/
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        boolean carry = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 > 9) {
                digits[i] = 0;
                carry = true;
            } else {
                digits[i] = digits[i] + 1;
                carry = false;
                break;
            }
        }
        int[] result = digits;
        if (carry) {
            result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{0})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1, 9})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9, 9})));
    }

}
