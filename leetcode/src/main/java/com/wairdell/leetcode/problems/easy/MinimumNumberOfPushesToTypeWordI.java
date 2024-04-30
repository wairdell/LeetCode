package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/6 16:03
 * desc   : 输入单词需要的最少按键次数 I https://leetcode.cn/problems/minimum-number-of-pushes-to-type-word-i
 */
public class MinimumNumberOfPushesToTypeWordI {

    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWordI wordI = new MinimumNumberOfPushesToTypeWordI();
//        System.out.println(wordI.minimumPushes("abcde"));
        System.out.println(wordI.minimumPushes("xycdefghij"));
    }

    public int minimumPushes(String word) {
        int l = word.length();
        int ans = 0;
        int base = 1;
        while (l > 0) {
            ans += Math.min(8, l) * base;
            l -= 8;
            base++;
        }
        return ans;
    }

}
