package com.wairdell.leetcode.problems.easy;

import java.util.HashSet;

/**
 * date   : 2024/5/6 17:13
 * desc   : 最长公共前缀的长度 https://leetcode.cn/problems/find-the-length-of-the-longest-common-prefix
 */
public class FindTheLengthOfTheLongestCommonPrefix {

    public static void main(String[] args) {
        FindTheLengthOfTheLongestCommonPrefix prefix = new FindTheLengthOfTheLongestCommonPrefix();
        System.out.println(prefix.longestCommonPrefix(new int[]{1, 10, 100}, new int[]{1000}));
        System.out.println(prefix.longestCommonPrefix(new int[]{1, 2, 3}, new int[]{4, 4, 4}));
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> prefixSet = new HashSet<>();
        for (int num : arr1) {
            String numStr = String.valueOf(num);
            for (int i = numStr.length(); i > 0; i--) {
                prefixSet.add(numStr.substring(0, i));
            }
        }
        int ans = 0;
        for (int num : arr2) {
            String numStr = String.valueOf(num);
            if (numStr.length() <= ans) continue;
            for (int i = 1; i <= numStr.length(); i++) {
                if (!prefixSet.contains(numStr.substring(0, i))) break;
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }


}
