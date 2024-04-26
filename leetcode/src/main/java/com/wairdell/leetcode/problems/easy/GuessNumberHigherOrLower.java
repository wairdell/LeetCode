package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/25 17:26
 * desc   : 猜数字大小 https://leetcode.cn/problems/guess-number-higher-or-lower
 */
public class GuessNumberHigherOrLower {

    public static void main(String[] args) {
        GuessNumberHigherOrLower lower = new GuessNumberHigherOrLower();
        System.out.println(lower.guessNumber(1));
//        System.out.println(lower.guessNumber(2126753390));
    }

    public int guessNumber(int n) {
        int l = 1, r = n;
        int mid;
        int ret;
        while (true) {
            mid = l + (r - l) / 2;
            ret = guess(mid);
            if (ret == 0) return mid;
            if (ret == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
    }

    int guess(int num) {
        int pick = 1;
        if (pick < num) {
            return -1;
        } else if (pick > num) {
            return 1;
        }
        return 0;
    }

}
