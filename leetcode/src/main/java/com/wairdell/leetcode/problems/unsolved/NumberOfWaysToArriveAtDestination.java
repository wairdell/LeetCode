package com.wairdell.leetcode.problems.unsolved;

import java.util.Arrays;
import java.util.Map;

/**
 * date   : 2024/4/18 11:01
 * desc   : 到达目的地的方案数 https://leetcode.cn/problems/number-of-ways-to-arrive-at-destination/
 */
public class NumberOfWaysToArriveAtDestination {

    public int countPaths(int n, int[][] roads) {
        int INF = Integer.MAX_VALUE / 2;
        int ans = 0;

        int[][] graph = new int[n][n];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], INF);
        }
        for (int i = 0; i < roads.length; i++) {
            graph[roads[i][0]][roads[i][1]] = roads[i][2];
            graph[roads[i][1]][roads[i][0]] = roads[i][2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        for (int i = 0; i < dist.length; i++) {
            dist[i] = graph[i][n - 1];
            if (dist[i] <= n) ans++;
        }
        dist[0] = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            int u = -1, min = INF;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }
            if (u == -1) return 0;

            visited[u] = true;

            /*for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    if (dist[u] + dist[])
                }
            }*/

        }
        return ans;
    }

}
