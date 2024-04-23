package com.wairdell.leetcode.problems.easy;

/**
 * author : fengqiao
 * date   : 2023/3/7 16:19
 * desc   : 最长回文串 https://leetcode.cn/problems/longest-palindrome/
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int singleCount = 0;
        int result = 0;
        boolean[] upperChar = new boolean[26];
        boolean[] lowerChar = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            boolean[] container;
            int index;
            if (charAt >= 'a' && charAt <= 'z') {
                container = lowerChar;
                index = charAt - 'a';
            } else {
                container = upperChar;
                index = charAt - 'A';
            }
            if (container[index]) {
                singleCount--;
                result += 2;
                container[index] = false;
            } else {
                singleCount++;
                container[index] = true;
            }
        }
        if (singleCount > 0) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
        System.out.println(new LongestPalindrome().longestPalindrome("a"));
        System.out.println(new LongestPalindrome().longestPalindrome("aaaaaccc"));

    }
}
