package com.wairdell.leetcode.problems;

import java.util.HashSet;
import java.util.Map;

/**
 * date   : 2024/5/6 17:22
 * desc   : 字符串及其反转中是否存在同一子字符串 https://leetcode.cn/problems/existence-of-a-substring-in-a-string-and-its-reverse
 */
public class ExistenceOfASubstringInAStringAndItsReverse {

    public static void main(String[] args) {
        ExistenceOfASubstringInAStringAndItsReverse existence = new ExistenceOfASubstringInAStringAndItsReverse();
        System.out.println(existence.isSubstringPresent("leetcode"));
        System.out.println(existence.isSubstringPresent("abcd"));
        System.out.println(existence.isSubstringPresent("abcba"));
    }

    public boolean isSubstringPresent(String s) {
        HashSet<String> prefixSet = new HashSet<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) return true;
            if (prefixSet.contains("" + s.charAt(i) + s.charAt(i - 1))) return true;
            prefixSet.add("" + s.charAt(i - 1) + s.charAt(i));
        }
        return false;
    }

}
