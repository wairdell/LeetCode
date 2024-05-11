package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;

/**
 * date   : 2024/5/11 17:14
 * desc   : 半径为 k 的子数组平均值 https://leetcode.cn/problems/k-radius-subarray-averages
 */
public class KRadiusSubarrayAverages {

    public static void main(String[] args) {
        KRadiusSubarrayAverages averages = new KRadiusSubarrayAverages();
        System.out.println(Arrays.toString(averages.getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3)));
//        System.out.println(Arrays.toString(averages.getAverages(new int[]{100000}, 0)));
//        System.out.println(Arrays.toString(averages.getAverages(new int[]{8, 8, 8}, 1)));
        System.out.println(100000 * (2 * 40000 + 1));
    }

    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        int sum = 0;
        int rem = 2 * k + 1;
        int base = 0;
        if (k * 2 > nums.length) return ans;
        for (int i = 0; i < k * 2; i++) {
            sum += nums[i];
            if (sum >= rem) {
                base += (sum / rem);
                sum = sum % rem;
            }
        }
        for (int i = k; i < nums.length - k; i++) {
            sum += nums[i + k];
            if (sum >= rem) {
                base += (sum / rem);
                sum = sum % rem;
            }
            ans[i] = base;

            if (nums[i - k] > sum) {
                int abs = Math.abs(nums[i - k] - sum);
                base -= (abs / rem  + 1);
                sum = rem - (abs % rem);
            } else {
                sum -= nums[i - k];
            }
        }
        return ans;
    }

}
