package com.wairdell.leetcode;


/**
 * author : fengqiao
 * date   : 2023/2/2 9:52
 * desc   : 最长回文子串 https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        String result = s.substring(0, 1);
        int l = 1;
        for (int i = 0; i < s.length(); i++) {
            breakFor:
            for (int j = s.length() - 1; j >= i && j - i >= l; j--) {
                int k = 0;
                for (; k <= (j - i) / 2; k++) {
                    if (s.charAt(i + k) != s.charAt(j - k)) {
                        continue breakFor;
                    }
                }
                String substring = s.substring(i, j + 1);
                if (substring.length() > result.length()) {
                    result = substring;
                    l = substring.length();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new LongestPalindromicSubstring().longestPalindrome("cbbd"));
    }
}
