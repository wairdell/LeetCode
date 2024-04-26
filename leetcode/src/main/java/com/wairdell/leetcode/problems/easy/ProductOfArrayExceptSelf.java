package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;

/**
 * date   : 2024/4/26 16:08
 * desc   : 除自身以外数组的乘积 https://leetcode.cn/problems/product-of-array-except-self
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf self = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(self.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(self.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int multiple = 1;
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                if (zeroIndex != -1) return ans;
                zeroIndex = i;
            } else {
                multiple *= num;
            }
        }
        if (zeroIndex != -1) {
            ans[zeroIndex] = multiple;
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = multiple / nums[i];
        }
        return ans;
    }

}
