package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;

/**
 * author : fengqiao
 * date   : 2023/3/7 17:17
 * desc   : https://leetcode.cn/problems/array-partition/ 数组拆分
 */
public class ArrayPartition {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new ArrayPartition().arrayPairSum(new int[]{1, 4, 3, 2}));
        //1 2 2 5 6 6 // 14  1 2 5 6
        System.out.println(new ArrayPartition().arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
    }

}
