package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/21 11:22
 * desc   : 连续字符 https://leetcode.cn/problems/Consecutive-Characters
 */
public class ConsecutiveCharacters {

    public int maxPower(String s) {
        if (s.length() == 0) return 0;
        int max = 1;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                max = Math.max(max, ++count);
            } else {
                count = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ConsecutiveCharacters characters = new ConsecutiveCharacters();
        System.out.println(characters.maxPower("leetcode"));
        System.out.println(characters.maxPower("abbcccddddeeeeedcba"));
    }
}
