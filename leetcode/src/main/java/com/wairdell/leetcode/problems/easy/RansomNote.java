package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/26 20:52
 * desc   : 赎金信 https://leetcode.cn/problems/ransom-note
 */
public class RansomNote {

    public static void main(String[] args) {
        RansomNote note = new RansomNote();
        System.out.println(note.canConstruct("a", "b"));
        System.out.println(note.canConstruct("aa", "ab"));
        System.out.println(note.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int['z' - 'a' + 1];
        int negative = 0;
        for (int i = 0;  i < magazine.length(); i++) {
            char charAt = magazine.charAt(i);
            if (++cnt[charAt - 'a'] == 0) {
                negative--;
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char charAt = ransomNote.charAt(i);
            if (cnt[charAt - 'a']-- == 0) {
                negative++;
            }
        }
        return negative <= 0;
    }

}
