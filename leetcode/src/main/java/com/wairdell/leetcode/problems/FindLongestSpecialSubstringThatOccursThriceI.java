package com.wairdell.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * date   : 2024/5/6 15:15
 * desc   : 找出出现至少三次的最长特殊子字符串 I https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-i
 */
public class FindLongestSpecialSubstringThatOccursThriceI {

    public static void main(String[] args) {
        FindLongestSpecialSubstringThatOccursThriceI thriceI = new FindLongestSpecialSubstringThatOccursThriceI();
        System.out.println(thriceI.maximumLength("aaaaa"));
        System.out.println(thriceI.maximumLength("abcdef"));
        System.out.println(thriceI.maximumLength("abcaba"));
    }


    public int maximumLength(String s) {
        Map<String, Integer> cnt = new HashMap<>();
        int j = 0;
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
                j++;
            } else {
                j = 0;
            }
            String temp = "";
            for (int k = 0; k <= j; k++) {
                temp += s.charAt(i);
                int value = cnt.getOrDefault(temp, 0) + 1;
                cnt.put(temp, value);
                if (value >= 3) {
                    ans = Math.max(ans, temp.length());
                }
            }
        }
        return ans;
    }

}
