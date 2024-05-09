package com.wairdell.leetcode.problems.unsolved;

/**
 * date   : 2024/5/9 14:46
 * desc   : 使二进制字符串字符交替的最少反转次数 https://leetcode.cn/problems/minimum-number-of-flips-to-make-the-binary-string-alternating
 */
public class MinimumNumberOfFlipsToMakeTheBinaryStringAlternating {

    public static void main(String[] args) {
        MinimumNumberOfFlipsToMakeTheBinaryStringAlternating alternating = new MinimumNumberOfFlipsToMakeTheBinaryStringAlternating();
        System.out.println(alternating.minFlips("111000"));
        System.out.println(alternating.minFlips("010"));
        System.out.println(alternating.minFlips("1110"));
    }

    public int minFlips(String s) {
        //01010011010
        int ans1 = 0;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (i % 2 == 0 && charAt == '1') {
                ans1++;
            }
            if (i % 2 == 1 && charAt == '0') {
                ans1++;
            }
        }

        int ans2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (i % 2 == 0 && charAt == '0') {
                ans2++;
            }
            if (i % 2 == 1 && charAt == '1') {
                ans2++;
            }
        }
        return Math.min(ans1, ans2);
    }

}
