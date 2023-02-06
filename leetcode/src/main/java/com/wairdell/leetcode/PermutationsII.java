package com.wairdell.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/6 10:02
 * desc   : 全排列 II https://leetcode.cn/problems/permutations-ii/submissions/
 */
public class PermutationsII {


    public List<List<Integer>> permuteUnique(int[] nums) {
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
        List<Integer> exits = new ArrayList<>();
        for (int i1 = 0; i1 < nums.size(); i1++) {
            Integer integer = nums.get(i1);
            if (exits.contains(integer)) {
                continue;
            }
            exits.add(integer);
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

    public static void main(String[] args) {
        System.out.println("result = " + new PermutationsII().permuteUnique(new int[]{1,1,2}));
    }

}
