package com.wairdell.leetcode.problems.unsolved;

import java.util.Arrays;

/**
 * date   : 2024/4/30 10:27
 * desc   : 插入区间 https://leetcode.cn/problems/insert-interval
 */
public class InsertInterval {

    public static void main(String[] args) {
        InsertInterval interval = new InsertInterval();
        int[][] insert = interval.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        for (int i = 0; i < insert.length; i++) {
            System.out.println(Arrays.toString(insert[i]));
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int j = -1;
        int i = 0;
        for (; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] >= newInterval[0] && interval[1] <= newInterval[1]) {
                //目标范围包含
                if (j == -1) j = i;
            } else if (interval[0] >= newInterval[0] && interval[1] <= newInterval[0]) {
                //与目标前部分交叉
                if (j == -1) j = i;
            } else if (interval[0] >= newInterval[0] && interval[0] <= newInterval[1]) {
                //
                if (j == -1) j = i;
            } else {
                if (j != -1) {
                    break;
                }
            }
        }
        if (j != -1) {
            intervals[j][0] = Math.min(intervals[j][0], newInterval[0]);
            intervals[j][1] = Math.max(intervals[i][1], newInterval[1]);
            for (int k = j + 1; k < j + 1 + (i - j); k++) {
                intervals[k] = intervals[k + (i - j)];
            }
        }
        return intervals;
    }

}
