package com.wairdell.leetcode.problems.algorithm.bfs;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * date   : 2024/4/24 16:41
 * desc   : 二进制矩阵中的最短路径 https://leetcode.cn/problems/shortest-path-in-binary-matrix
 */
public class ShortestPathInBinaryMatrix {

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix.AStarImpl path = new ShortestPathInBinaryMatrix.AStarImpl();
        System.out.println(path.shortestPathBinaryMatrix(new int[][]{
                new int[]{0, 0, 0},
                new int[]{1, 1, 0},
                new int[]{1, 1, 0},
        }));//4

        System.out.println(path.shortestPathBinaryMatrix(new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
        }));//2

        System.out.println(path.shortestPathBinaryMatrix(new int[][]{
                new int[]{1, 0, 0},
                new int[]{1, 1, 0},
                new int[]{1, 1, 0},
        }));//-1

        System.out.println(path.shortestPathBinaryMatrix(new int[][]{
                        new int[]{0, 1, 0, 1, 0},
                        new int[]{1, 0, 0, 0, 1},
                        new int[]{0, 0, 1, 1, 1},
                        new int[]{0, 0, 0, 0, 0},
                        new int[]{1, 0, 1, 0, 0}
                }
        ));//6


        System.out.println(path.shortestPathBinaryMatrix(new int[][]{
                        new int[]{0, 0, 0, 0, 1, 1, 1, 1, 0},
                        new int[]{0, 1, 1, 0, 0, 0, 0, 1, 0},
                        new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0},
                        new int[]{1, 1, 0, 0, 1, 0, 0, 1, 1},
                        new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1},
                        new int[]{0, 1, 0, 1, 0, 0, 0, 0, 0},
                        new int[]{0, 0, 0, 1, 0, 1, 0, 0, 0},
                        new int[]{0, 1, 0, 1, 1, 0, 0, 0, 0},
                        new int[]{0, 0, 0, 0, 0, 1, 0, 1, 0},
                }
        ));//6

    }

    static class BfsImpl {
        static class Pair {

            int x;
            int y;

            int d;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public Pair(int x, int y, int d) {
                this.x = x;
                this.y = y;
                this.d = d;
            }

        }

        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            if (grid[0][0] == 1) return -1;
            if (grid[n - 1][m - 1] == 1) return -1;
            if (n == 1 && m == 1) return 1;
            int[] direction = new int[]{1, 0, -1};
            Set<Pair> dirs = new HashSet<>();
            for (int x : direction) {
                for (int y : direction) {
                    if (x != 0 || y != 0) {
                        dirs.add(new Pair(x, y));
                    }
                }
            }

            boolean[][] visited = new boolean[n][m];
            Deque<Pair> priorityQueue = new ArrayDeque<>();
            priorityQueue.add(new Pair(0, 0, 1));
            visited[0][0] = true;
            int ans = Integer.MAX_VALUE;
            while (!priorityQueue.isEmpty()) {
                Pair pair = priorityQueue.poll();
                for (Pair dir : dirs) {
                    int tx = pair.x + dir.x;
                    int ty = pair.y + dir.y;
                    if (tx < 0 || tx >= n || ty < 0 || ty >= m) continue;
                    if (tx == n - 1 && ty == m - 1) {
                        ans = Math.min(ans, pair.d + 1);
                    } else if (grid[tx][ty] != 1 && !visited[tx][ty]) {
                        priorityQueue.add(new Pair(tx, ty, pair.d + 1));
                        visited[tx][ty] = true;
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }


    static class AStarImpl {
        static class Pair {

            int x;
            int y;

            int d;

            double priority;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public Pair(int x, int y, int d, double priority) {
                this.x = x;
                this.y = y;
                this.d = d;
                this.priority = priority;
            }

        }

        //A*(启发式搜索)
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            if (grid[0][0] == 1) return -1;
            if (grid[n - 1][m - 1] == 1) return -1;
            if (n == 1 && m == 1) return 1;
            int[] direction = new int[]{1, 0, -1};
            Set<Pair> dirs = new HashSet<>();
            for (int x : direction) {
                for (int y : direction) {
                    if (x != 0 || y != 0) {
                        dirs.add(new Pair(x, y));
                    }
                }
            }

            boolean[][] visited = new boolean[n][m];
            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Math.max(n, m), new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return Double.compare(o1.priority, o2.priority);
                }
            });
            priorityQueue.add(new Pair(0, 0, 1, 0d));
            visited[0][0] = true;
            int ans = Integer.MAX_VALUE;
            while (!priorityQueue.isEmpty()) {
                Pair pair = priorityQueue.poll();
                for (Pair dir : dirs) {
                    int tx = pair.x + dir.x;
                    int ty = pair.y + dir.y;
                    if (tx < 0 || tx >= n || ty < 0 || ty >= m) continue;
                    if (tx == n - 1 && ty == m - 1) {
                        return pair.d + 1;
//                    ans = Math.min(ans, pair.d + 1);
                    } else if (grid[tx][ty] != 1 && !visited[tx][ty]) {
                        double cost = pair.priority + 1 + distance(tx, ty, pair.x, pair.y);
                        priorityQueue.add(new Pair(tx, ty, pair.d + 1, cost));
                        visited[tx][ty] = true;
                    }
                }
            }
            return -1;
        }

        //启发式函数，使用两点距离坐标公式
        public double distance(int x, int y, int targetX, int targetY) {
            return Math.sqrt(Math.pow(targetX - x, 2) + Math.pow(targetY - y, 2));
        }

    }



}
