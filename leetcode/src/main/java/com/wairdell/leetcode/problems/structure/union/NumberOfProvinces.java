package com.wairdell.leetcode.problems.structure.union;

import java.util.HashSet;
import java.util.Set;

/**
 * date   : 2024/5/7 10:39
 * desc   : 省份数量 https://leetcode.cn/problems/number-of-provinces
 */
public class NumberOfProvinces {

    public static void main(String[] args) {
        NumberOfProvinces provinces = new NumberOfProvinces();
        System.out.println(provinces.findCircleNum(new int[][]{
                new int[]{1, 1, 0},
                new int[]{1, 1, 0},
                new int[]{0, 0, 1},
        }));

        System.out.println(provinces.findCircleNum(new int[][]{
                new int[]{1, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 1},
        }));
    }

    static class UnionFinder {

        private int n;
        private int[] parent;

        UnionFinder(int n) {
            this.n = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int getRoot(int i) {
            while (parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        void union(int p, int q) {
            int rootP = getRoot(p), rootQ = getRoot(q);
            if (rootP != rootQ) {
                parent[rootQ] = rootP;
            }
        }

    }

    public int findCircleNum(int[][] isConnected) {
        UnionFinder unionFinder = new UnionFinder(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[i].length; j++) {
                if (i == j) continue;
                if (isConnected[i][j] == 1) {
                    unionFinder.union(i, j);
                }
            }
        }
        Set<Integer> rootSet = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            rootSet.add(unionFinder.getRoot(i));
        }
        return rootSet.size();
    }

}
