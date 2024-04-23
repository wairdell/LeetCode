package com.wairdell.leetcode.problems.structure.disjoint;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * date   : 2024/4/22 9:56
 * desc   : 岛屿数量 https://leetcode.cn/problems/number-of-islands
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands.BfsImpl number = new NumberOfIslands.BfsImpl();
        System.out.println(number.numIslands(new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'},
        }));//1

        System.out.println(number.numIslands(new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'},
        }));//3

        System.out.println(number.numIslands(new char[][]{
                new char[]{'1'},
                new char[]{'1'}
        }));//1

        System.out.println(number.numIslands(new char[][]{
                new char[]{'1', '1', '1'},
                new char[]{'0', '1', '1'},
                new char[]{'1', '1', '1'},
        }));//1

        System.out.println(number.numIslands(new char[][]{
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '0', '1', '0', '1'},
                new char[]{'1', '1', '1', '0', '1'},
        }));//1
    }

    static class Impl {



    }

    static class BfsImpl {

        private int[] dx = new int[]{0, 0, 1, -1};
        private int[] dy = new int[]{1, -1, 0, 0};

        public int numIslands(char[][] grid) {
            Deque<int[]> deque = new ArrayDeque<>();
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        deque.add(new int[]{i, j});
                        count++;
                        grid[i][j] = '0';
                        while (!deque.isEmpty()) {
                            int[] poll = deque.poll();
                            int x = poll[0], y = poll[1];
                            for (int k = 0; k < dx.length; k++) {
                                int tx = x + dx[k];
                                int ty = y + dy[k];
                                if (tx >= 0 && tx < grid.length && ty >= 0 && ty < grid[tx].length && grid[tx][ty] == '1') {
                                    deque.add(new int[]{tx, ty});
                                    grid[tx][ty] = '0';
                                }
                            }
                        }
                    }
                }
            }
            return count;
        }

    }

    static class DisjointImpl {

        static class UnionFind {
            private int[] parent;
            private int count;

            UnionFind(int n) {
                parent = new int[n];
                count = n;
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            int find(int p) {
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }

            void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) return;
                parent[rootQ] = rootP;
            }

        }

        public int indexFromXY(int n, int x, int y) {
            return x * n + y;
        }

        public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            UnionFind unionFind = new UnionFind(n * m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        //右面
                        if (j + 1 < m && grid[i][j + 1] == '1') {
                            unionFind.union(indexFromXY(m, i, j), indexFromXY(m, i, j + 1));
                        }
                        //下面
                        if (i + 1 < n && grid[i + 1][j] == '1') {
                            unionFind.union(indexFromXY(m, i, j), indexFromXY(m, i + 1, j));
                        }
                    }
                }
            }
            Set<Integer> rootSet = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        rootSet.add(unionFind.find(indexFromXY(m, i, j)));
                    }
                }
            }
            return rootSet.size();
        }
    }


}
