package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/9 10:04
 * desc   : 检查两个字符串是否几乎相等 https://leetcode.cn/problems/check-whether-two-strings-are-almost-equivalent/
 */
public class CheckWhetherTwoStringsAreAlmostEquivalent {

    public static void main(String[] args) {

    }

    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] wordCnt1 = new int['z' - 'a' + 1];
        int[] wordCnt2 = new int['z' - 'a' + 1];
        for (int i = 0; i < word1.length(); i++) {
            char charAt1 = word1.charAt(i);
            wordCnt1[charAt1 - 'a']++;

            char charAt2 = word2.charAt(i);
            wordCnt2[charAt2 - 'a']++;
        }
        for (int i = 0; i < wordCnt1.length; i++) {
            if (Math.abs(wordCnt1[i] - wordCnt2[i]) > 3) {
                return false;
            }
        }
        return true;
    }

}
