package com.wairdell.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * date   : 2024/4/27 23:30
 * desc   : 长度最小的子数组 https://leetcode.cn/problems/minimum-size-subarray-sum
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        MinimumSizeSubarraySum sum = new MinimumSizeSubarraySum();
        System.out.println(sum.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));//2
        System.out.println(sum.minSubArrayLen(4, new int[]{1, 4, 4}));//1
        System.out.println(sum.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));//0
        System.out.println(sum.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));

//        System.out.println(sum.search(new int[]{1, 3, 5, 7, 9, 13, 17, 19}, 0, 0, 7));
    }

    public int search(int[] nums, int target, int l, int r) {
        int right = r;
        while (l <= r) {
            int mid = (l + r) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (l <= right && nums[l] < target) {
            return l;
        } else if (l > 0 && nums[l - 1] < target) {
            return l - 1;
        }
        return -1;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int[] sumArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumArray[i] = sum;
            int find = search(sumArray, sum - target, 0, i);
            if (find > -1) {
                min = Math.min(min, i - find);
                if (min == 1) {
                    return min;
                }
            } else if (sum >= target) {
                min = Math.min(min, i + 1);
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
