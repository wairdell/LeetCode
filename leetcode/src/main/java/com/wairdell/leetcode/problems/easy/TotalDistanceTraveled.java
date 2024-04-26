package com.wairdell.leetcode.problems.easy;
/**
 *    date   : 2024/4/25 9:40
 *    desc   : 总行驶距离 https://leetcode.cn/problems/total-distance-traveled
 */
public class TotalDistanceTraveled {

    public static void main(String[] args) {
        TotalDistanceTraveled traveled = new TotalDistanceTraveled();
        System.out.println(traveled.distanceTraveled(5, 10));
        System.out.println(traveled.distanceTraveled(1, 2));
    }

    public int distanceTraveled(int mainTank, int additionalTank) {
        if (mainTank < 5) {
            return mainTank * 10;
        } else {
            return (mainTank + Math.min(additionalTank, mainTank / 4 - (mainTank % 4 == 0 ? 1 : 0))) * 10;
        }
    }

}
