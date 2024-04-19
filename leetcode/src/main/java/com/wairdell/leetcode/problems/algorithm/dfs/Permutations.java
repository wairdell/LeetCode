package com.wairdell.leetcode.problems.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/6 10:02
 * desc   : 全排列 https://leetcode.cn/problems/permutations/
 */
public class Permutations {


    static class Impl {

        public List<List<Integer>> permute(int[] nums) {
            if (nums.length == 0) {
                return new ArrayList<>();
            }
            LinkedList<Integer> list = new LinkedList<>();
            for (int num : nums) {
                list.add(num);
            }
            return dfs(list);
        }

        private List<List<Integer>> dfs(List<Integer> nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.size() == 1) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums.get(0));
                result.add(list);
                return result;
            }
            for (int i1 = 0; i1 < nums.size(); i1++) {
                Integer integer = nums.get(i1);
                nums.remove(i1);
                List<List<Integer>> dfs = dfs(nums);
                nums.add(i1, integer);
                for (List<Integer> list : dfs) {
                    list.add(0, integer);
                    result.add(list);
                }
            }
            return result;
        }

    }

    static class ImplNew {
        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int num : nums) {
                list.add(num);
            }
            return dfs(list, new ArrayList<Integer>());
        }

        private List<List<Integer>> dfs(List<Integer> nums, List<Integer> path) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums.isEmpty()) {
                ans.add(path);
                return ans;
            }
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> list = new ArrayList<>(path);
                Integer remove = nums.remove(i);
                list.add(remove);
                ans.addAll(dfs(nums, list));
                nums.add(i, remove);
            }
            return ans;
        }


    }



    public static void main(String[] args) {
        ImplNew impl = new ImplNew();
        System.out.println("result = " + impl.permute(new int[]{1,1,2}));//[[1, 1, 2], [1, 2, 1], [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 1, 1]]
    }

}
