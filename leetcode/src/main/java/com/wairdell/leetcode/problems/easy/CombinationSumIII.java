package com.wairdell.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * date   : 2024/4/21 11:06
 * desc   : 组合总和 III https://leetcode.cn/problems/combination-sum-iii
 */
public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        return dfs(k, n, 0, 0, new ArrayList<Integer>());
    }

    private List<List<Integer>> dfs(int k, int n, int sum, int i, List<Integer> list) {
        if (sum == n && list.size() == k) {
            List<Integer> ans = new ArrayList<>(list);
            return Collections.singletonList(ans);
        }
        if (sum > n || list.size() >= k) {
            return Collections.emptyList();
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int j = i; j < 9; j++) {
            list.add(j + 1);
            result.addAll(dfs(k, n, sum + (j + 1), j + 1, list));
            list.remove(list.size() - 1);

        }
        return result;
    }

    public static void main(String[] args) {
        CombinationSumIII sumIII = new CombinationSumIII();
        System.out.println(sumIII.combinationSum3(3, 7));
        System.out.println(sumIII.combinationSum3(3, 9));
    }

}
