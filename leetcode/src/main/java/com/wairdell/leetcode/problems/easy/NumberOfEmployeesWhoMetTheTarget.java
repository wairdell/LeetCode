package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/30 9:35
 * desc   : 满足目标工作时长的员工数目 https://leetcode.cn/problems/number-of-employees-who-met-the-target
 */
public class NumberOfEmployeesWhoMetTheTarget {

    public static void main(String[] args) {
        NumberOfEmployeesWhoMetTheTarget target = new NumberOfEmployeesWhoMetTheTarget();
        System.out.println(target.numberOfEmployeesWhoMetTarget(new int[]{0, 1, 2, 3, 4}, 2));
        System.out.println(target.numberOfEmployeesWhoMetTarget(new int[]{5, 1, 4, 2, 2}, 6));
    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int hour : hours) {
            if (hour >= target) {
                count++;
            }
        }
        return count;
    }

}
