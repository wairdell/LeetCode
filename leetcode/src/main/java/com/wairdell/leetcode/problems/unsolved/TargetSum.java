package com.wairdell.leetcode.problems.unsolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/7 18:22
 * desc   : 目标和 https://leetcode.cn/problems/Target-Sum/description/
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        List<Integer> integerList = calc(nums, 0);
        int sum = 0;
        for (Integer integer : integerList) {
            if (integer == target) {
                sum++;
            }
        }
        return sum;
    }

    public List<Integer> calc(int[] nums, int index) {
        if (index == nums.length - 1) {
            return Arrays.asList(nums[index], nums[index] * -1);
        }
        ArrayList<Integer> result = new ArrayList<>();
        List<Integer> integerList = calc(nums, index + 1);
        for (Integer integer : integerList) {
            result.add(nums[index] + integer);
            result.add(-nums[index] + integer);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new TargetSum().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println("result = " + new TargetSum().findTargetSumWays(new int[]{1}, 1));
    }

}
