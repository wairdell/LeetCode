package com.wairdell.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/6 14:40
 * desc   : 三角形最小路径和 https://leetcode.cn/problems/triangle/
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> current = triangle.get(i);
            for (int j = 0; j < current.size(); j++) {
                Integer t = current.get(j);
                List<Integer> previous = triangle.get(i - 1);
                if (j == 0) {
                    current.set(j, previous.get(0) + t);
                } else if (j == current.size() - 1) {
                    current.set(j, previous.get(j - 1) + t);
                } else {
                    current.set(j, t + Math.min(previous.get(j - 1), previous.get(j)));
                }
                if (i == triangle.size() - 1) {
                    min = Math.min(min, current.get(j));
                }
            }
        }
        /*if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int[] widgetCache = new int[triangle.size()];
        int colSize = triangle.size();
        widgetCache[0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < colSize; i++) {
            int rowSize = triangle.get(i).size();
            int lastWidget = 0;
            for (int j = 0; j < rowSize; j++) {
                int widget = widgetCache[j];
                if (j == 0) {
                    widgetCache[j] = widget + triangle.get(i).get(j);
                } else if (j == rowSize - 1) {
                    widgetCache[j] = lastWidget + triangle.get(i).get(j);
                } else {
                    widgetCache[j] = Math.min(lastWidget, widget) + triangle.get(i).get(j);
                }
                lastWidget = widget;
                if (i == colSize - 1) {
                    min = Math.min(min, widgetCache[j]);
                }
            }
        }*/
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3, 4));
        input.add(Arrays.asList(6, 5, 7));
        input.add(Arrays.asList(4, 1, 8, 3));

        //     -1
        //    3   2
        //   1  -2 -1
        /*input.add(Arrays.asList(-1));
        input.add(Arrays.asList(3, 2));
        input.add(Arrays.asList(1, -2, -1));*/
        System.out.println("result = " + new Triangle().minimumTotal(input));
    }
}
