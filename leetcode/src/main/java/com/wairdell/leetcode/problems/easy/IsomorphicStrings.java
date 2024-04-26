package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;

/**
 * date   : 2024/4/26 21:04
 * desc   : 同构字符串 https://leetcode.cn/problems/isomorphic-strings
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        IsomorphicStrings x = new IsomorphicStrings();
//        System.out.println(x.isIsomorphic("egg", "add"));
//        System.out.println(x.isIsomorphic("foo", "bar"));
//        System.out.println(x.isIsomorphic("paper", "title"));
        System.out.println(x.isIsomorphic("badc", "baba"));
    }

    public boolean isIsomorphic(String s, String t) {
        char[] mapping = new char[128];
        Arrays.fill(mapping, ((char) 128));
        boolean[] used = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char sChatAt = s.charAt(i);
            char tChatAt = t.charAt(i);
            if (mapping[sChatAt] == 128) {
                if (used[tChatAt]) return false;
                mapping[sChatAt] = tChatAt;
                used[tChatAt] = true;
            } else {
                if (mapping[sChatAt] != tChatAt) {
                    return false;
                }
            }
        }
        return true;
    }

}
