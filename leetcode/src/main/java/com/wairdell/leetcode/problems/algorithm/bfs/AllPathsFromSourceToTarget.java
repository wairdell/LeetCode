package com.wairdell.leetcode.problems.algorithm.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * date   : 2024/4/30 11:28
 * desc   : 所有可能的路径 https://leetcode.cn/problems/all-paths-from-source-to-target
 */
public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        AllPathsFromSourceToTarget paths = new AllPathsFromSourceToTarget();
        System.out.println(paths.allPathsSourceTarget(new int[][]{
                {1, 2},
                {3},
                {3},
                {}
        }));
        System.out.println(paths.allPathsSourceTarget(new int[][]{
                {4, 3, 1},
                {3, 2, 4},
                {3},
                {4},
                {}
        }));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ansList = new ArrayList<>();
        Set<Deque<Integer>> set = new HashSet<>();
        set.add(new ArrayDeque<>(Collections.singletonList(0)));
        while (!set.isEmpty()) {
            Set<Deque<Integer>> nextSet = new HashSet<>();
            for (Deque<Integer> deque : set) {
                int[] paths = graph[deque.getLast()];
                for (int path : paths) {
                    if (path == graph.length - 1) {
                        ArrayList<Integer> ans = new ArrayList<>(deque);
                        ans.add(path);
                        ansList.add(ans);
                    } else {
                        if (!deque.contains(path)) {
                            Deque<Integer> next = new ArrayDeque<>(deque);
                            next.add(path);
                            nextSet.add(next);
                        }
                    }
                }
                set = nextSet;
            }
        }
        return ansList;
    }


}
