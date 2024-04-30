package com.wairdell.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * date   : 2024/4/29 16:27
 * desc   : 连接后等于目标字符串的字符串对 https://leetcode.cn/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target
 */
public class NumberOfPairsOfStringsWithConcatenationEqualToTarget {

    public static void main(String[] args) {
        NumberOfPairsOfStringsWithConcatenationEqualToTarget target = new NumberOfPairsOfStringsWithConcatenationEqualToTarget();
        System.out.println(target.numOfPairs(
                new String[]{"777", "7", "77", "77"}, "7777"));
        System.out.println(target.numOfPairs(
                new String[]{"123", "4", "12", "34"}, "1234"));

        System.out.println(target.numOfPairs(
                new String[]{"1", "1", "1"}, "11"));
    }

    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (String num : nums) {
            if (target.startsWith(num)) {
                String find = target.substring(num.length());
                if (countMap.getOrDefault(find, 0) > 0) {
                    ans += countMap.getOrDefault(find, 0);
                    if (num.equals(find)) {
                        ans--;
                    }
                }
            }
            if (target.endsWith(num)) {
                String find = target.substring(0, target.length() - num.length());
                if (countMap.getOrDefault(find, 0) > 0) {
                    ans += countMap.getOrDefault(find, 0);
                    if (num.equals(find)) {
                        ans--;
                    }
                }
            }
            if (countMap.containsKey(num)) {
                int count = countMap.get(num);
                if (count <= 1) {
                    countMap.remove(num);
                } else {
                    countMap.put(num, count - 1);
                }
            }
        }
        return ans;
    }

}
