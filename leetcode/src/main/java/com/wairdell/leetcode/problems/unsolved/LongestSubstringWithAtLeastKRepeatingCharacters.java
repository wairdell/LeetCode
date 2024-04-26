package com.wairdell.leetcode.problems.unsolved;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * date   : 2024/4/25 14:57
 * desc   : 至少有 K 个重复字符的最长子串 https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithAtLeastKRepeatingCharacters substring = new LongestSubstringWithAtLeastKRepeatingCharacters();
//        System.out.println(substring.longestSubstring("aaabb", 3));
//        System.out.println(substring.longestSubstring("ababbc", 2));
        System.out.println(substring.longestSubstring("ababbc", 3));
    }

    public int longestSubstring(String s, int k) {
        if (k == 1) return s.length();
        int ans = 0;
        int[] cnt = new int['z' - 'a' + 1];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            cnt[charArray[i] - 'a']++;
        }
        Set<Character> appearSet = new HashSet<>();
        List<int[]> valuableList = new ArrayList<>();
        int j = -1;
        for (int i = 0; i < charArray.length; i++) {
            if (cnt[charArray[i]] < k || i == charArray.length - 1) {
                if (j > 0 && k * appearSet.size() <= i - j + 1) {
                    valuableList.add(new int[]{j, i});
                }
                j = -1;
                appearSet.clear();
            } else {
                j++;
                appearSet.add(charArray[i]);
            }
        }
        return ans;
    }


}
