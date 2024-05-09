package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/9 18:31
 * desc   : 反转字符串中的元音字母 https://leetcode.cn/problems/reverse-vowels-of-a-string
 */
public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        ReverseVowelsOfAString vowels = new ReverseVowelsOfAString();
        System.out.println(vowels.reverseVowels("hello"));
        System.out.println(vowels.reverseVowels("leetcode"));
    }

    char[] vowels = new char[]{'a', 'e','i','o','u', 'A', 'E','I','O','U'};

    private boolean isVowels(char ch) {
        for (char vowel : vowels) {
            if (vowel == ch) {
                return true;
            }
        }
        return false;
    }

    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] array = s.toCharArray();
        while (i < j) {
            while (i < j && !isVowels(array[i])) {
                i++;
            }
            while (i < j && !isVowels(array[j])) {
                j--;
            }
            if (i < j) {
                char temp = array[i];
                array[i++] = array[j];
                array[j--] = temp;
            }
        }
        return new String(array);
    }

}
