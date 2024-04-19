package com.wairdell.leetcode.problems.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/8 9:58
 * desc   : 子集 II https://leetcode.cn/problems/Subsets-II
 */
public class SubsetsII {

    /*public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return result;
    }*/
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return dfs(nums, new ArrayList<Integer>(), 0);
    }

    private List<List<Integer>> dfs(int[] nums, List<Integer> exist, int k) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ans.add(exist);
        if (k >= nums.length) return ans;
        for (int i = k; i < nums.length; i++) {
            if (i > k && nums[i] == nums[i - 1]) continue;
            ArrayList<Integer> list = new ArrayList<>(exist);
            list.add(nums[i]);

            ans.addAll(dfs(nums, list, i + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SubsetsII().subsetsWithDup(new int[]{1, 2, 2}));
    }

}
