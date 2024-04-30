package com.wairdell.leetcode.problems.unsolved;

/**
 * date   : 2024/5/2 23:06
 * desc   : 雇佣 K 名工人的最低成本 https://leetcode.cn/problems/minimum-cost-to-hire-k-workers
 */
public class MinimumCostToHireKWorkers {

    public static void main(String[] args) {

    }

    static class Scale {
        int index;
        double ratio;

        public Scale(int index, double ratio) {
            this.index = index;
            this.ratio = ratio;
        }
    }

    private void swap(Scale[] scales, int i, int j) {
        Scale temp = scales[i];
        scales[i] = scales[j];
        scales[j] = temp;
    }

    private int[] partition(Scale[] scales, int l, int r) {
        int less = l, i = l, greater = r;
        double pivot = scales[l].ratio;
        while (i <= r) {
            if (scales[i].ratio < pivot) {
                swap(scales, i++, less++);
            } else if (scales[i].ratio > pivot){
                swap(scales, i, greater--);
            } else {
                i++;
            }
        }
        return new int[]{less, greater};
    }

    private void quickSort(Scale[] scales, int l, int r) {
        if (l >= r) return;
        int[] ret = partition(scales, l, r);
        quickSort(scales, l, ret[0] - 1);
        quickSort(scales, ret[1] + 1, r);
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        Scale[] scale = new Scale[quality.length];
        for (int i = 0; i < quality.length; i++) {
            scale[i] = new Scale(i, wage[i] * 1d / quality[i]);
        }
        for (int i = k; i < scale.length; i++) {

        }
        return 0d;
    }

}
