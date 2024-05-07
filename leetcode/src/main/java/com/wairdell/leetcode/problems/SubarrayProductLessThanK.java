package com.wairdell.leetcode.problems;

/**
 * date   : 2024/5/7 15:22
 * desc   : 乘积小于 K 的子数组 https://leetcode.cn/problems/subarray-product-less-than-k
 */
public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        SubarrayProductLessThanK thanK = new SubarrayProductLessThanK();
//        System.out.println(thanK.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
//        System.out.println(thanK.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
        System.out.println(thanK.numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int mul = 1;
        int j = -1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            mul *= nums[i];
            while (j < i && mul >= k) {
                j++;
                mul /= nums[j];
            }
            ans += (i - j);
        }
        return ans;
    }

}
