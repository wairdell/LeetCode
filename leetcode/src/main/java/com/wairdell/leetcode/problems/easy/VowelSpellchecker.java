package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * date   : 2024/5/13 16:39
 * desc   : 元音拼写检查器 https://leetcode.cn/problems/vowel-spellchecker
 */
public class VowelSpellchecker {

    public static void main(String[] args) {
        VowelSpellchecker spellchecker = new VowelSpellchecker();
        System.out.println(Arrays.toString(spellchecker.spellchecker(new String[]{"KiTe", "kite", "hare", "Hare"},
                new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"})));
    }

    private Set<Character> vowelList = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    private String replaceVowel(String word) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (vowelList.contains(charArray[i])) {
                charArray[i] = '*';
            }
        }
        return new String(charArray);
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String, String> wordMapping = new HashMap<>();
        for (String word : wordlist) {
            String lowerCase = word.toLowerCase();
            if (!wordMapping.containsKey(lowerCase + "|")) {
                wordMapping.put(lowerCase + "|", word);
                String vowel = replaceVowel(lowerCase);
                if (!wordMapping.containsKey(vowel + "|")) {
                    wordMapping.put(vowel + "|", word);
                }
            }
            wordMapping.put(word, word);
        }
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (wordMapping.containsKey(query)) {
                ans[i] = query;
                continue;
            }
            String lowerCase = query.toLowerCase();
            if (wordMapping.containsKey(lowerCase + "|")) {
                ans[i] = wordMapping.get(lowerCase + "|");
                continue;
            }
            String vowel = replaceVowel(lowerCase);
            ans[i] = wordMapping.getOrDefault(vowel + "|", "");
        }
        return ans;
    }

}
