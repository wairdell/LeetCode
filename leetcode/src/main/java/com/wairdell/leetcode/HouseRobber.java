package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/7 16:18
 * desc   : 打家劫舍 https://leetcode.cn/problems/house-robber/
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println("result = " + new HouseRobber().rob(new int[]{2,7,9,3,1}));
    }

}
