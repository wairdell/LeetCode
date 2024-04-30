package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * date   : 2024/5/1 21:02
 * desc   : 不同的平均值数目 https://leetcode.cn/problems/number-of-distinct-averages
 */
public class NumberOfDistinctAverages {

    public static void main(String[] args) {
        NumberOfDistinctAverages averages = new NumberOfDistinctAverages();
        System.out.println(averages.distinctAverages(new int[]{4, 1, 4, 0, 3, 5}));
    }

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i <= (nums.length / 2); i++) {
            hashSet.add(nums[i] + nums[nums.length - 1 - i]);
        }
        return hashSet.size();
    }


}
