package com.wairdell.leetcode.problems.unclear;

/**
 * date   : 2024/1/26 17:12
 * desc   : 只出现一次的数字 II https://leetcode.cn/problems/single-number-ii/description/
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int xor2 = 0;
        int xor3 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 == (xor3 ^ nums[i]) || (xor3 ^ nums[i]) == xor) {
                xor2 ^= nums[i];
                System.out.print(nums[i] + "->");
            }
            xor3 ^= nums[i];
        }
        return xor ^ xor2;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(new SingleNumberII().singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.out.println(new SingleNumberII().singleNumber(new int[]{99, 0, 1, 0, 1, 0, 1}));
        System.out.println(new SingleNumberII().singleNumber(new int[]{0, 99, 1, 0, 1, 0, 1}));
    }

}
