package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/11 16:30
 * desc   : 各位相加 https://leetcode.cn/problems/add-digits
 */
public class AddDigits {

    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

}
