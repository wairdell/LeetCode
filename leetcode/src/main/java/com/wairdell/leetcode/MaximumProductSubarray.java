package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/7 14:52
 * desc   : 乘积最大子数组 https://leetcode.cn/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int multiply = 1;
        int negativeMin = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            multiply *= nums[i];
            if (multiply > 0) {
                max = Math.max(Math.max(multiply, max), nums[i]);
            } else if (multiply == 0) {
                multiply = 1;
                negativeMin = 0;
                max = Math.max(max, 0);
            } else {
                if (negativeMin != 0) {
                    max = Math.max(multiply / negativeMin, max);
                    negativeMin = Math.max(negativeMin, multiply);
                } else {
                    max = Math.max(multiply, max);
                    negativeMin = multiply;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new MaximumProductSubarray().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println("result = " + new MaximumProductSubarray().maxProduct(new int[]{-2, 3, 2}));
        System.out.println("result = " + new MaximumProductSubarray().maxProduct(new int[]{-2, 0, -1}));
        System.out.println("result = " + new MaximumProductSubarray().maxProduct(new int[]{-2}));
        System.out.println("result = " + new MaximumProductSubarray().maxProduct(new int[]{0, 2}));
        System.out.println("result = " + new MaximumProductSubarray().maxProduct(new int[]{1, 0, -1, 2, 3, -5, -2}));
    }

}
