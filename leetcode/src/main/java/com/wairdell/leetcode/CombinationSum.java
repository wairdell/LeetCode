package com.wairdell.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * author : fengqiao
 * date   : 2023/2/6 13:32
 * desc   : 组合总和 https://leetcode.cn/problems/combination-sum/
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, target, result, 0, new Stack<Integer>());
        return result;
    }

    private void dfs(int[] candidates, int begin, int target, List<List<Integer>> result, int sum, Stack<Integer> stack) {
        for (int i = begin; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (sum + candidate == target) {
                ArrayList<Integer> list = new ArrayList<>(stack);
                list.add(candidate);
                result.add(list);
//                return;
            } else if (sum + candidate < target) {
                stack.push(candidate);
                dfs(candidates, i, target, result, sum + candidate, stack);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println("result = " + new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println("result = " + new CombinationSum().combinationSum(new int[]{4, 2, 8}, 8));
    }

}
