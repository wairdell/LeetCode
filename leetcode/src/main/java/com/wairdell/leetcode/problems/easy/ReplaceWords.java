package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * date   : 2024/5/10 17:57
 * desc   : 单词替换 https://leetcode.cn/problems/replace-words
 */
public class ReplaceWords {

    public static void main(String[] args) {
        ReplaceWords words = new ReplaceWords();
        System.out.println(words.replaceWords(Arrays.asList("cat","bat","rat"), "the cattle was rattled by the battery"));
        System.out.println(words.replaceWords(Arrays.asList("a","b","c"), "aadsfasf absbs bbab cadsfafs"));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder ans = new StringBuilder();
        StringBuilder word = new StringBuilder();
        String root = null;
        Set<String> dictionarySet = new HashSet<>(dictionary);
        for (int i = 0; i < sentence.length(); i++) {
            char charAt = sentence.charAt(i);
            if (charAt == ' ' || i == sentence.length() - 1) {
                if (charAt != ' ') word.append(charAt);
                String prefix = ans.length() > 0 ? " " : "";
                ans.append(prefix).append(root == null ? word : root);
                word.delete(0, word.length());
                root = null;
            } else {
                word.append(charAt);
                if (root == null && dictionarySet.contains(word.toString())) {
                    root = word.toString();
                }
            }
        }
        return ans.toString();
    }

}
