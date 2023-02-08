package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/8 14:02
 * desc   :
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num == 0) {
                nums[i] = nums.length + 1;
            } else if (num == nums.length + 1) {
                num = 0;
            }
            if (num < nums.length) {
                int p = nums[num];
                if (p == 0) {
                    nums[num] = -nums.length - 1;
                } else if (p > 0) {
                    nums[num] = -p;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        return nums.length;
    }

    //如果只是少一位数字的情况可以用下面的解法
    /*public int missingNumber(int[] nums) {
        int i = 0;
        int res = 0;
        for (int num : nums) {
            res -= num;
            res += i;
            i++;
        }
        return res + i;
    }*/

    public static void main(String[] args) {
        System.out.println("result = " + new MissingNumber().missingNumber(new int[]{3, 0, 1}));
        System.out.println("result = " + new MissingNumber().missingNumber(new int[]{0, 1}));
        System.out.println("result = " + new MissingNumber().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println("result = " + new MissingNumber().missingNumber(new int[]{0}));
        System.out.println("result = " + new MissingNumber().missingNumber(new int[]{2, 0}));
        System.out.println("result = " + new MissingNumber().missingNumber(new int[]{0, 1, 2, 4, 4}));
    }

}
