package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;

/**
 * date   : 2024/5/7 14:26
 * desc   : 相对名次 https://leetcode.cn/problems/relative-ranks
 */
public class RelativeRanks {

    public static void main(String[] args) {
        RelativeRanks ranks = new RelativeRanks();
        System.out.println(Arrays.toString(ranks.findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(ranks.findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
    }

    private void swap(int[] score, int[] rank, int i, int j) {
        int temp = score[i];
        score[i] = score[j];
        score[j] = temp;

        temp = rank[i];
        rank[i] = rank[j];
        rank[j] = temp;
    }

    private void quickSort(int[] score, int[] rank, int s, int e) {
        if (s >= e) return;
        int l = s, r = e;
        while (l < r) {
            while (l < r && score[r] <= score[s]) {
                r--;
            }
            while (l < r && score[l] >= score[s]) {
                l++;
            }
            swap(score, rank, l, r);
        }
        swap(score, rank, l, s);
        quickSort(score, rank, s, l - 1);
        quickSort(score, rank, l + 1, e);
    }

    public String[] findRelativeRanks(int[] score) {
        int[] rank = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            rank[i] = i;
        }
        quickSort(score, rank, 0, score.length - 1);
        String[] ans = new String[score.length];
        for (int i = 0; i < rank.length; i++) {
            if (i == 0) {
                ans[rank[i]] = "Gold Medal";
            } else if (i == 1) {
                ans[rank[i]] = "Silver Medal";
            } else if (i == 2) {
                ans[rank[i]] = "Bronze Medal";
            } else {
                ans[rank[i]] = String.valueOf(i + 1);
            }
        }
        return ans;
    }

}
