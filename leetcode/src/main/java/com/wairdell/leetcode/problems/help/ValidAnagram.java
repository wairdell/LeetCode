package com.wairdell.leetcode.problems.help;

/**
 * author : fengqiao
 * date   : 2023/2/8 14:23
 * desc   : 有效的字母异位词 https://leetcode.cn/problems/valid-anagram/
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] chatCountArray = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            chatCountArray[s.charAt(i) - 'a']++;
            chatCountArray[t.charAt(i) - 'a']--;
        }
        for (int count : chatCountArray) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new ValidAnagram().isAnagram("anagram", "nagaram"));
        System.out.println("result = " + new ValidAnagram().isAnagram("rat", "car"));
    }

}
