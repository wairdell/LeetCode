package com.wairdell.leetcode.problems.structure.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * date   : 2024/4/26 11:17
 * desc   : 每日温度 https://leetcode.cn/problems/daily-temperatures
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures temperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(temperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(temperatures.dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(temperatures.dailyTemperatures(new int[]{30, 60, 90})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.lastElement()] < temperatures[i]) {
                Integer pop = stack.pop();
                ans[pop] = i - pop;
            }
            stack.push(i);
        }
        return ans;
    }

}
