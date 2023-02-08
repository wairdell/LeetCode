package com.wairdell.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * author : fengqiao
 * date   : 2023/2/8 10:49
 * desc   : 合并区间 https://leetcode.cn/problems/merge-intervals/
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, 0, intervals.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        });
        int length = intervals.length;
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
                intervals[i][0] = intervals[i - 1][0];
            } else {
                arrayList.add(intervals[i - 1]);
            }
            if (i == length - 1) {
                arrayList.add(intervals[i]);
            }
        }
        int[][] result = new int[arrayList.size()][];
        arrayList.toArray(result);
        return result;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        };
        System.out.println("result = " + Arrays.deepToString(new MergeIntervals().merge(input)));

        input = new int[][]{
                new int[]{1,4},
                new int[]{4,5}
        };
        System.out.println("result = " + Arrays.deepToString(new MergeIntervals().merge(input)));

        input = new int[][]{
                new int[]{1,3}
        };
        System.out.println("result = " + Arrays.deepToString(new MergeIntervals().merge(input)));
    }

}
