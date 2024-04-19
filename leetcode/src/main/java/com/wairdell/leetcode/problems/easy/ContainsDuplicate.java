package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;

/**
 * author : fengqiao
 * date   : 2023/2/8 13:48
 * desc   : 存在重复元素 https://leetcode.cn/problems/contains-duplicate/
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new ContainsDuplicate().containsDuplicate(new int[]{1, 2, 3, 1}));
    }


}
