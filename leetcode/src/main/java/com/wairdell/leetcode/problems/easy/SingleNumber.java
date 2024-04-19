package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/1/26 16:51
 * desc   : 只出现一次的数字 https://leetcode.cn/problems/single-number/
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{2, 2, 1}));
        System.out.println(new SingleNumber().singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(new SingleNumber().singleNumber(new int[]{1}));
    }


}
