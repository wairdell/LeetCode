package com.wairdell.leetcode.problems.structure.disjoint;

import java.util.Arrays;

/**
 * date   : 2024/4/22 15:02
 * desc   : 被围绕的区域 https://leetcode.cn/problems/surrounded-regions
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        SurroundedRegions regions = new SurroundedRegions();
        char[][] input = null;

        input = new char[][]{
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'X'},
        };
        regions.solve(input);
        printResult(input);

        input = new char[][]{
                new char[]{'X', 'O', 'X', 'X'},
                new char[]{'O', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'O'},
                new char[]{'O', 'X', 'O', 'X'},
        };
        regions.solve(input);
        printResult(input);


        input = new char[][]{
                new char[]{'X','O','X','O','X','O','O','O','X','O'},
                new char[]{'X','O','O','X','X','X','O','O','O','X'},
                new char[]{'O','O','O','O','O','O','O','O','X','X'},
                new char[]{'O','O','O','O','O','O','X','O','O','X'},
                new char[]{'O','O','X','X','O','X','X','O','O','O'},
                new char[]{'X','O','O','X','X','X','O','X','X','O'},
                new char[]{'X','O','X','O','O','X','X','O','X','O'},
                new char[]{'X','X','O','X','X','O','X','O','O','X'},
                new char[]{'O','O','O','O','X','O','X','O','X','O'},
                new char[]{'X','X','O','X','X','X','X','O','O','O'}
        };
        regions.solve(input);
        printResult(input);
    }

    public static void printResult(char[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
        System.out.println();
        System.out.println();
    }

    static class UnionFind {

        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
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

    int indexOfPoint(int m, int i, int j) {
        return m * i + j;
    }

    boolean isRootBorderIndex(UnionFind unionFind, int n, int m, int index) {
        int p = unionFind.find(index);
        int px = p / m;
        int py = p % m;
        return px == 0 || px == n - 1 || py == 0 || py == m - 1;
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};
        UnionFind unionFind = new UnionFind(n * m);
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'X') continue;
                for (int k = 0; k < dx.length; k++) {
                    int tx = i + dx[k];
                    int ty = j + dy[k];
                    if (board[tx][ty] == 'O') {
                        if (isRootBorderIndex(unionFind, n, m, indexOfPoint(m, tx, ty))) {
                            unionFind.union(indexOfPoint(m, tx, ty), indexOfPoint(m, i, j));
                            break;
                        } else {
                            unionFind.union(indexOfPoint(m, i, j), indexOfPoint(m, tx, ty));
                        }
                    }
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] != 'O') continue;
                if (!isRootBorderIndex(unionFind, n, m, indexOfPoint(m, i, j))) {
                    board[i][j] = 'X';
                }
            }
        }
    }

}
