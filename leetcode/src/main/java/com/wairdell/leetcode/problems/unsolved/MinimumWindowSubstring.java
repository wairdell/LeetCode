package com.wairdell.leetcode.problems.unsolved;

/**
 * date   : 2024/4/26 20:35
 * desc   :
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] tcnt = new int['z' - 'a' + 1];
        char[] tArray = t.toCharArray();
        for (int i = 0; i < tArray.length; i++) {
            tcnt[tArray[i] - 'a']++;
        }
        int [] scnt = new int['z' - 'a' + 1];
        char[] sArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            scnt[sArray[i] - 'a']++;
        }
        int i = 0;
        return "";
    }

}
