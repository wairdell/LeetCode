package com.wairdell.leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * date   : 2024/5/14 13:38
 * desc   : 完成所有任务需要的最少轮数 https://leetcode.cn/problems/minimum-rounds-to-complete-all-tasks
 */
public class MinimumRoundsToCompleteAllTasks {

    public static void main(String[] args) {
        MinimumRoundsToCompleteAllTasks tasks = new MinimumRoundsToCompleteAllTasks();
        System.out.println(tasks.minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
        System.out.println(tasks.minimumRounds(new int[]{2,3,3}));
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> taskCount = new HashMap<>();
        for (int task : tasks) {
            taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);
        }
        int ans = 0;
        Set<Map.Entry<Integer, Integer>> entrySet = taskCount.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            int count = entry.getValue();
            if (count < 2) return -1;
            ans += (count / 3 + (count % 3 == 0 ? 0 : 1));
        }
        return ans;
    }

}
