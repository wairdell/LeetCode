package com.wairdell.leetcode.exapmle;

/**
 * date   : 2024/4/22 9:48
 * desc   : 并查集
 */
public class DisjointSets {

    private int[] parent;
    private int count;

    public DisjointSets(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootQ] = rootP;
        count--;
    }

}
