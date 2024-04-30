package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/6 15:29
 * desc   : 边界上的蚂蚁 https://leetcode.cn/problems/ant-on-the-boundary
 */
public class AntOnTheBoundary {

    public static void main(String[] args) {
        AntOnTheBoundary ant = new AntOnTheBoundary();
        System.out.println(ant.returnToBoundaryCount(new int[]{2, 3, -5}));
        System.out.println(ant.returnToBoundaryCount(new int[]{3, 2, -3, -4}));
    }

    public int returnToBoundaryCount(int[] nums) {
        int ans = 0;
        int x = 0;
        for (int num : nums) {
            x += num;
            if (x == 0) ans++;
        }
        return ans;
    }

}
