package com.wairdell.leetcode.problems.easy;

/**
 * author : fengqiao
 * date   : 2023/2/13 15:03
 * desc   : 柠檬水找零 https://leetcode.cn/problems/lemonade-change/
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if (bill == 5) {
                fiveCount++;
            } else if (bill == 10) {
                if (fiveCount > 0) {
                    fiveCount--;
                    tenCount++;
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (tenCount > 0 && fiveCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else if (fiveCount > 2) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new LemonadeChange().lemonadeChange(new int[]{5, 5, 5, 10, 20}));
//        System.out.println(new LemonadeChange().lemonadeChange(new int[]{5, 5, 10, 10, 20}));
        System.out.println(new LemonadeChange().lemonadeChange(new int[]{5, 5, 5, 5, 10, 5, 10, 10, 10, 20}));
    }
}
