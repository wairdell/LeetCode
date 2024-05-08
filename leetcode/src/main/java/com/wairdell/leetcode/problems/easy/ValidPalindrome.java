package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/8 18:20
 * desc   : 验证回文串 https://leetcode.cn/problems/valid-palindrome
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome palindrome = new ValidPalindrome();
//        System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(palindrome.isPalindrome("race a car"));
        System.out.println(palindrome.isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        char INF = ' ';
        int i = 0;
        int j = s.length() - 1;
        char find = INF;
        while (i < j) {
            while (find == INF && i < j) {
                char charAt = s.charAt(i);
                if (charAt >= 'a' && charAt <= 'z' || (charAt >= '0' && charAt <= '9')) {
                    find = charAt;
                } else if (charAt >= 'A' && charAt <= 'Z') {
                    find = (char) (charAt - 'A' + 'a');
                } else {
                    i++;
                }
            }
            while (find != INF && i <= j) {
                char charAt = s.charAt(j);
                if (charAt >= 'a' && charAt <= 'z' || (charAt >= '0' && charAt <= '9')) {
                    if (charAt != find) return false;
                    find = INF;
                } else if (charAt >= 'A' && charAt <= 'Z') {
                    if ((char) (charAt - 'A' + 'a') != find) return false;
                    find = INF;
                }
                j--;
            }
            i++;
        }
        return true;
    }

}
