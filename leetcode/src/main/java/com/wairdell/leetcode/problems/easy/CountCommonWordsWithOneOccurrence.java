package com.wairdell.leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * date   : 2024/5/9 15:10
 * desc   : 统计出现过一次的公共字符串 https://leetcode.cn/problems/count-common-words-with-one-occurrence
 */
public class CountCommonWordsWithOneOccurrence {

    public static void main(String[] args) {
        CountCommonWordsWithOneOccurrence occurrence = new CountCommonWordsWithOneOccurrence();
        System.out.println(occurrence.countWords(new String[]{"leetcode", "is", "amazing", "as", "is"}, new String[]{"amazing", "leetcode", "is"}));
        System.out.println(occurrence.countWords(new String[]{"b", "bb", "bbb"}, new String[]{"a", "aa", "aaa"}));
        System.out.println(occurrence.countWords(new String[]{"a", "ab"}, new String[]{"a", "a", "a", "ab"}));
    }

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> word1Map = new HashMap<>();
        Map<String, Integer> word2Map = new HashMap<>();
        for (String word : words1) {
            word1Map.put(word, word1Map.getOrDefault(word, 0) + 1);
        }

        for (String word : words2) {
            word2Map.put(word, word2Map.getOrDefault(word, 0) + 1);
        }
        Integer oneInteger = 1;
        int ans = 0;
        for (Map.Entry<String, Integer> entry : word1Map.entrySet()) {
            if (oneInteger.equals(entry.getValue()) && oneInteger.equals(word2Map.get(entry.getKey()))) {
                ans++;
            }
        }
        return ans;
    }

}
