package com.wairdell.leetcode.problems.help;

/**
 * author : fengqiao
 * date   : 2023/2/1 17:07
 * desc   : 最大子数组和 https://leetcode.cn/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum - min, max);
            min = Math.min(sum, min);
        }
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length; j > i; j--) {
                int sum = 0;
                //下面一层接口不用 for 循环每次求，可以转为为常数级操作
                for (int k = i; k < j; k++) {
                    sum += nums[k];
                }
                max = Math.max(max, sum);
            }
        }*/
        /*int[] sumArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sumArray[i] = (i > 0 ? sumArray[i - 1] : 0) + nums[i];
        }
        sumArray[j] - sumArray[i] 就可以求出 i ~ j 范围的数组之和
        */
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("result = " + new MaximumSubarray().maxSubArray(input));
    }

}
