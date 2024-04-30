package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;

/**
 * date   : 2024/4/30 15:20
 * desc   : 三角形的最大周长 https://leetcode.cn/problems/largest-perimeter-triangle
 */
public class LargestPerimeterTriangle {

    public static void main(String[] args) {
        System.out.println(new LargestPerimeterTriangle().largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(new LargestPerimeterTriangle().largestPerimeter(new int[]{1, 2, 1, 10}));
    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

}
