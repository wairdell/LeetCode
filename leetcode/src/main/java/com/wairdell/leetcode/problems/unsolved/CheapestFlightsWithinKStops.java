package com.wairdell.leetcode.problems.unsolved;

import java.util.Arrays;

/**
 * date   : 2024/4/21 12:57
 * desc   : K 站中转内最便宜的航班 https://leetcode.cn/problems/cheapest-flights-within-k-stops
 */
public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        int[][] graph = new int[n][n];
        int[] dist = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
        }
        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        Arrays.fill(dist, INF);
        for (int i = 0; i < n; i++) {
            dist[i] = graph[src][i];
        }
        boolean[] visited = new boolean[n];
        visited[src] = true;
        dist[src] = 0;
        while (true) {
            int min = Integer.MAX_VALUE;
            int t = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] != INF && min > dist[i]) {
                    min = dist[i];
                    t = i;
                }
            }
            if (t == -1) break;
            visited[t] = true;
            if (count[t] >= k) continue;
            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;
                if (graph[t][i] == INF) continue;
                if (dist[i] > dist[t] + graph[t][i]) {
                    dist[i] = dist[t] + graph[t][i];
                    count[i] = count[t] + 1;
                }
            }
        }
        return dist[dst] == INF ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops stops = new CheapestFlightsWithinKStops();
        int ret = 0;
        /*ret = stops.findCheapestPrice(4,
                new int[][]{new int[]{0, 1, 100},
                        new int[]{1, 2, 100},
                        new int[]{2, 0, 100},
                        new int[]{1, 3, 600},
                        new int[]{2, 3, 200}},
                0, 3, 1);
        System.out.println(ret);

        ret = stops.findCheapestPrice(3,
                new int[][]{new int[]{0, 1, 100},
                        new int[]{1, 2, 100},
                        new int[]{0, 2, 500}},
                0, 2, 1);
        System.out.println(ret);*/

        ret = stops.findCheapestPrice(4,
                new int[][]{new int[]{0, 1, 1},
                        new int[]{0, 2, 5},
                        new int[]{1, 2, 1},
                        new int[]{2, 3, 1}},
                0, 2, 1);
        System.out.println(ret);
    }

}
