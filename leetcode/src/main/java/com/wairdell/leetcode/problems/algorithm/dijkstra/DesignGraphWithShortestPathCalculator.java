package com.wairdell.leetcode.problems.algorithm.dijkstra;

import java.util.Arrays;

/**
 * date   : 2024/4/18 13:42
 * desc   : 设计可以求最短路径的图类 https://leetcode.cn/problems/design-graph-with-shortest-path-calculator
 */
public class DesignGraphWithShortestPathCalculator {

    public static void main(String[] args) {
        /*Graph graph = new Graph(4, new int[][]{new int[]{0, 2, 5},
                new int[]{0, 1, 2},
                new int[]{1, 2, 1},
                new int[]{3, 0, 3}
        });
        System.out.println(graph.shortestPath(3, 2));
        System.out.println(graph.shortestPath(0, 3));
        graph.addEdge(new int[]{1, 3, 4});
        System.out.println(graph.shortestPath(0, 3));*/
        /**
         * [[13,[]],
         * [9,3],
         * [[11,1,873094]],
         * [3,10],
         * [[0,9,601498]],
         * [[12,0,824080]],
         * [[12,4,459292]],
         * [[6,9,7876]],
         * [[11,7,5479]],
         * [[11,12,802]],
         * [2,9],
         * [2,6],
         * [[0,11,441770]],
         * [3,7],
         * [[11,0,393443]],
         * [4,2],
         * [[10,5,338]],
         * [[6,1,305]],
         * [[5,0,154]]]
         */
        Graph graph = new Graph(13, new int[][]{new int[]{7, 2, 131570},
                new int[]{9, 4, 622890},
                new int[]{9, 1, 812365},
                new int[]{1, 3, 399349},
                new int[]{10, 2, 407736},
                new int[]{6, 7, 880509},
                new int[]{1, 4, 289656},
                new int[]{8, 0, 802664},
                new int[]{6, 4, 826732},
                new int[]{10, 3, 567982},
                new int[]{5, 6, 434340},
                new int[]{4, 7, 833968},
                new int[]{12, 1, 578047},
                new int[]{8, 5, 739814},
                new int[]{10, 9, 648073},
                new int[]{1, 6, 679167},
                new int[]{3, 6, 933017},
                new int[]{0, 10, 399226},
                new int[]{1, 11, 915959},
                new int[]{0, 12, 393037},
                new int[]{11, 5, 811057},
                new int[]{6, 2, 100832},
                new int[]{5, 1, 731872},
                new int[]{3, 8, 741455},
                new int[]{2, 9, 835397},
                new int[]{7, 0, 516610},
                new int[]{11, 8, 680504},
                new int[]{3, 11, 455056},
                new int[]{1, 0, 252721}});
        graph.addEdge(new int[]{9, 1, 812365});

        System.out.println(graph.shortestPath(3, 2));
        System.out.println(graph.shortestPath(0, 3));
        graph.addEdge(new int[]{1, 3, 4});
        System.out.println(graph.shortestPath(0, 3));

    }

    static class Graph {

        private static final int INF = Integer.MAX_VALUE / 2;
        private int[][] graph;

        private int n;

        public Graph(int n, int[][] edges) {
            this.n = n;
            graph = new int[n][n];
            for (int i = 0; i < graph.length; i++) {
                Arrays.fill(graph[i], INF);
            }
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                graph[edge[0]][edge[1]] = edge[2];
            }
        }

        public void addEdge(int[] edge) {
            graph[edge[0]][edge[1]] = edge[2];
        }

        public int shortestPath(int node1, int node2) {
            int[] dist = new int[n];
            for (int i = 0; i < dist.length; i++) {
                dist[i] = graph[node1][i];
            }
            dist[node1] = 0;
            boolean[] visited = new boolean[n];
            visited[node1] = true;
            while (true) {
                int min = Integer.MAX_VALUE;
                int k = -1;
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && dist[j] != INF && dist[j] < min) {
                        min = dist[j];
                        k = j;
                    }
                }
                if (k == -1) break;
                visited[k] = true;
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && graph[k][j] != INF) {
                        dist[j] = Math.min(dist[j], dist[k] + graph[k][j]);
                    }
                }
            }
            return dist[node2] == INF ? -1 : dist[node2];
        }


    }

}
