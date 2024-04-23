package com.wairdell.leetcode.problems.novelty;

import java.util.Arrays;

/**
 * date   : 2024/1/26 16:56
 * desc   : 只出现一次的数字 III https://leetcode.cn/problems/single-number-iii/
 */
public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int digit = 0;
        int firstDiffBinary = 0;
        do {
            if ((xor & (1 << digit)) > 0) {
                firstDiffBinary = 1 << digit;
                break;
            }
            digit++;
        } while (digit < 32);
        int xor1 = 0,xor2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & firstDiffBinary) > 0) {
                xor1 ^= nums[i];
            } else {
                xor2 ^= nums[i];
            }
        }
        return new int[]{xor1, xor2};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SingleNumberIII().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println(Arrays.toString(new SingleNumberIII().singleNumber(new int[]{-1, 0})));
        System.out.println(Arrays.toString(new SingleNumberIII().singleNumber(new int[]{0, 1})));
        System.out.println(Arrays.toString(new SingleNumberIII().singleNumber(new int[]{0, 1, 1, 2})));
    }


}
