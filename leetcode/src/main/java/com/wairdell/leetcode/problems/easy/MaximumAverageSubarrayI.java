package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/25 17:51
 * desc   : 子数组最大平均数 I https://leetcode.cn/problems/maximum-average-subarray-i
 */
public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        MaximumAverageSubarrayI subarrayI = new MaximumAverageSubarrayI();
        System.out.println(subarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(subarrayI.findMaxAverage(new int[]{5}, 1));
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int ans = sum;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            ans = Math.max(sum, ans);
        }
        return ans * 1d / k;
    }


}
