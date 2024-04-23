package com.wairdell.leetcode.problems.unsolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * date   : 2024/4/18 15:25
 * desc   : 概率最大的路径 https://leetcode.cn/problems/path-with-maximum-probability/description/
 */
public class PathWithMaximumProbability {

    public static void main(String[] args) {
        PathWithMaximumProbability.DijkstraImpl probability = new PathWithMaximumProbability.DijkstraImpl();
        double ret = 0f;
        ret = probability.maxProbability(3, new int[][]{new int[]{0, 1},
                        new int[]{1, 2},
                        new int[]{0, 2}},
                new double[]{0.5, 0.5, 0.2},
                0,
                2);
        System.out.println(ret); //0.25

        ret = probability.maxProbability(3, new int[][]{new int[]{0, 1},
                        new int[]{1, 2},
                        new int[]{0, 2}},
                new double[]{0.5, 0.5, 0.3},
                0,
                2);
        System.out.println(ret); //0.3

        ret = probability.maxProbability(3, new int[][]{new int[]{0, 1}},
                new double[]{0.5},
                0,
                2);
        System.out.println(ret); //0.0

        ret = probability.maxProbability(10, new int[][]{new int[]{0, 3},
                        new int[]{1, 7},
                        new int[]{1, 2},
                        new int[]{0, 9},
                },
                new double[]{0.31, 0.9, 0.86, 0.36},
                2,
                3);
        System.out.println(ret); //0.0

        ret = probability.maxProbability(5, new int[][]{new int[]{2, 3},
                        new int[]{1, 2},
                        new int[]{3, 4},
                        new int[]{1, 3},
                        new int[]{1, 4},
                        new int[]{0, 1},
                        new int[]{2, 4},
                        new int[]{0, 4},
                        new int[]{0, 2},
                },
                new double[]{0.06, 0.26, 0.49, 0.25, 0.2, 0.64, 0.23, 0.21, 0.77},
                0,
                3);
        System.out.println(ret); //0.16
    }

    static class DijkstraImpl {

        double INF = 0;

        public void putSuccProb(Map<Integer, Map<Integer, Double>> probMap, int start, int end, double prob) {
            Map<Integer, Double> probList = probMap.get(start);
            if (probList == null) {
                probList = new HashMap<>();
                probMap.put(start, probList);
            }
            probList.put(end, prob);
        }

        public double findSuccProb(Map<Integer, Map<Integer, Double>> probMap, int start, int end) {
            Map<Integer, Double> succProbList = probMap.get(start);
            if (succProbList == null) return INF;
            return findSuccProb(succProbList, end);
        }

        public double findSuccProb(Map<Integer, Double> probList, int end) {
            if (probList.containsKey(end)) return probList.get(end);
            return INF;
        }

        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

            double[] probability = new double[n];
            Arrays.fill(probability, INF);
            Map<Integer, Map<Integer, Double>> probMap = new HashMap<>();
            for (int i = 0; i < edges.length; i++) {
                int x = edges[i][0];
                int y = edges[i][1];
                double prob = succProb[i];
                putSuccProb(probMap, x, y, prob);
                putSuccProb(probMap, y, x, prob);
            }

            Map<Integer, Double> probList = probMap.get(start_node);
            if (probList == null) return 0;

            for (int i = 0; i < n; i++) {
                if (start_node != i) probability[i] = findSuccProb(probList, i);
            }
            probability[start_node] = 1;
            List<Integer> notVisitedList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                notVisitedList.add(i);
            }
            while (true) {
                int i = -1;
                double max = 0;
                for (int j = 0; j < notVisitedList.size(); j++) {
                    int index = notVisitedList.get(j);
                    if (probability[index] != INF && probability[index] > max) {
                        i = j;
                        max = probability[index];
                    }
                }
                if (i == -1) break;
                i = notVisitedList.remove(i);
                if (i == end_node) return max;
                for (int j = 0; j < notVisitedList.size(); j++) {
                    int index = notVisitedList.get(j);
                    double prob = findSuccProb(probMap, i, index);
                    if (prob == INF) continue;
                    probability[index] = Math.max(probability[index], probability[i] * prob);
                }
            }
            return probability[end_node];
        }

    }

    static class HeapImpl {

        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            int INF = -1;
            double[][] graph = new double[n][n];
            for (int i = 0; i < graph.length; i++) {
                Arrays.fill(graph[i], INF);
            }
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                graph[edge[0]][edge[1]] = succProb[i];
                graph[edge[1]][edge[0]] = succProb[i];
            }
            class Node {
                int target;
                int from;
                double wight;

                public Node(int target, int from, double wight) {
                    this.target = target;
                    this.from = from;
                    this.wight = wight;
                }
            }
            PriorityQueue<Node> queue = new PriorityQueue<>(n, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return (int) (o1.wight - o2.wight);
                }
            });
            queue.add(new Node(start_node, start_node, 1));
//        boolean[] visited = new boolean[n];
//        visited[start_node] = true;
            double[] prob = new double[n];
            prob[start_node] = 1;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int t = node.target;
                if (node.wight < prob[t]) continue;
                for (int i = 0; i < n; i++) {
                    if (graph[t][i] == INF) continue;
                    double temp = node.wight * graph[t][i];
                    if (prob[i] < temp) {
                        queue.offer(new Node(i, t, temp));
                        prob[i] = temp;
                    }
                }
            }
            return prob[end_node];
        }

    }


}
