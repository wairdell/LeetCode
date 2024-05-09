package com.wairdell.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * date   : 2024/5/9 15:49
 * desc   : 组合总和 II https://leetcode.cn/problems/combination-sum-ii
 */
public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII sumII = new CombinationSumII();
        System.out.println(sumII.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(sumII.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2(candidates, target, 0, 0, new ArrayList<>());
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target, int sum, int i, List<Integer> nums) {
        if (sum == target) {
            return Collections.singletonList(new ArrayList<>(nums));
        }
        if (sum > target || i >= candidates.length) return Collections.emptyList();
        List<List<Integer>> ans = new ArrayList<>();
        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            int index = nums.size();
            nums.add(index, candidates[j]);
            ans.addAll(combinationSum2(candidates, target, sum + candidates[j], j + 1, nums));
            nums.remove(index);
        }
        return ans;
    }

}
