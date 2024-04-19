package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/19 13:47
 * desc   : 爬楼梯 https://leetcode.cn/problems/climbing-stairs/description/
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs stairs = new ClimbingStairs();
        System.out.println(stairs.climbStairs(2));
        System.out.println(stairs.climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int previous1 = 1;
        int previous2 = 2;
        for (int i = 2; i < n; i++) {
            int temp = previous2;
            previous2 = previous1 + previous2;
            previous1 = temp;
        }
        return previous2;
    }
}
