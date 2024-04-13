package com.wairdell.leetcode;

import java.util.Arrays;

/**
 * author : fengqiao
 * date   : 2023/9/15 16:18
 * desc   : 三个数的最大乘积 https://leetcode.cn/problems/maximum-product-of-three-numbers
 */
public class MaximumProductOfThreeNumbers {

    public static void main(String[] args) {
        MaximumProductOfThreeNumbers maximumProductOfThreeNumbers = new MaximumProductOfThreeNumbers();
        System.out.println(maximumProductOfThreeNumbers.maximumProduct(new int[]{1, 2, 3}));
        System.out.println(maximumProductOfThreeNumbers.maximumProduct(new int[]{1,2,3,4}));
        System.out.println(maximumProductOfThreeNumbers.maximumProduct(new int[]{-1,-2,-3}));
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 3) return nums[0] * nums[1] * nums[2];
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
    }

}
