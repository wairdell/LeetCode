package com.wairdell.leetcode.problems.algorithm.dijkstra;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * date   : 2024/4/18 9:36
 * desc   : 网络延迟时间 https://leetcode.cn/problems/network-delay-time/description/
 */
public class NetworkDelayTime {

    public static void main(String[] args) {
        int ret = -1;
        NetworkDelayTime.DijkstraImpl o = new NetworkDelayTime.DijkstraImpl();

        ret = o.networkDelayTime(new int[][]{new int[]{2, 1, 1}, new int[]{2, 3, 1}, new int[]{3, 4, 1}}, 4, 2);
        System.out.println(ret);

        ret = o.networkDelayTime(new int[][]{new int[]{1, 2, 1}}, 2, 1);
        System.out.println(ret);

        ret = o.networkDelayTime(new int[][]{new int[]{1, 2, 1}}, 2, 2);
        System.out.println(ret);

    }

    static class Impl1 {
        public int networkDelayTime(int[][] times, int n, int k) {
            TreeSet<Integer> deque = new TreeSet<>();
            deque.add(k);
            int[] shortest = new int[n];
            Arrays.fill(shortest, -1);
            shortest[k - 1] = 0;
            Integer poll = null;
            while ((poll = deque.pollFirst()) != null) {
                int i = poll;
                int base = shortest[i - 1];
                if (base == -1) break;
                for (int j = 0; j < times.length; j++) {
                    if (times[j][0] != i) continue;
                    int endPoint = times[j][1];
                    int distance = times[j][2];
                    int previous = shortest[endPoint - 1];
                    if (previous == -1 || base + distance < previous) {
                        shortest[endPoint - 1] = base + distance;
                        deque.add(endPoint);
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < shortest.length; i++) {
                if (shortest[i] == -1) return -1;
                max = Math.max(max, shortest[i]);
            }
            return max;
        }
    }

    static class DijkstraImpl {

        public int networkDelayTime(int[][] times, int n, int k) {
            int INF = Integer.MAX_VALUE / 2;

            //这个用于每个节点直接到其他节点的距离
            int[][] graph = new int[n][n];
            for (int i = 0; i < graph.length; i++) {
                Arrays.fill(graph[i], INF);
            }
            for (int i = 0; i < times.length; i++) {
                int[] time = times[i];
                graph[time[0] - 1][time[1] - 1] = time[2];
            }

            //这个用于每个节点到K节点的距离
            int[] dist = new int[n];
            Arrays.fill(dist, INF);
            //标记1
            for (int i = 0; i < dist.length; i++) {
                dist[i] = graph[k - 1][i];
            }
            dist[k - 1] = 0;

            //这个用于标记已用此节点去更新其他节点到k的距离
            boolean[] visited = new boolean[n];
            //标记1处for，已将 k 到各个边的距离更新了，所以无需在使用 k 去更新其他节点
            visited[k - 1] = true;

            for (int i = 0; i < n - 1; i++) {

                //这个for用于找到距离k最短的节点
                int min = INF;
                int u = -1;
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && dist[j] < min) {
                        min = dist[j];
                        u = j;
                    }
                }
                if (u == -1) return -1;

                //已找到距离k最短的节点作用去更新其他节点，那么下次就无需再使用
                visited[u] = true;

                //用找到的距离最短的节点去更新其他的节点
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && dist[u] + graph[u][j] < dist[j]) {
                        dist[j] = dist[u] + graph[u][j];
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < dist.length; i++) {
                ans = Math.max(ans, dist[i]);
            }
            return ans == INF ? -1 : ans;
        }

    }



}
