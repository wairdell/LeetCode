package com.wairdell.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * date   : 2024/4/27 18:37
 * desc   : 课程表 https://leetcode.cn/problems/course-schedule
 */
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule schedule = new CourseSchedule();
        System.out.println(schedule.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(schedule.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(schedule.canFinish(20, new int[][]{
                {0, 10},
                {3, 18},
                {5, 5},
                {6, 11},
                {11, 14},
                {13, 1},
                {15, 1},
                {17, 4}}));

        System.out.println(schedule.canFinish(3, new int[][]{
                {1, 0},
                {1, 2},
                {0, 1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> schedule = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            Set<Integer> parentSet = schedule.computeIfAbsent(prerequisite[0], k -> new HashSet<>());
            parentSet.add(prerequisite[1]);
        }
        Set<Map.Entry<Integer, Set<Integer>>> entrySet = schedule.entrySet();
        int[] visited = new int[numCourses];
        for (Map.Entry<Integer, Set<Integer>> entry : entrySet) {
            if (visited[entry.getKey()] == 0 && !dfs(schedule, visited, entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, Set<Integer>> schedule, int[] visited, int index) {
        visited[index] = 1;
        for (Integer v : schedule.get(index)) {
            if (visited[v] == 1) {
                return false;
            }
            if (!schedule.containsKey(v)) continue;
            if (visited[v] == 0) {
                if (!dfs(schedule, visited, v)) {
                    return false;
                }
            }
        }
        visited[index] = 2;
        return true;
    }


}
