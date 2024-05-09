package com.wairdell.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * date   : 2024/5/9 16:07
 * desc   : 单词拆分 II https://leetcode.cn/problems/word-break-ii
 */
public class WordBreakII {

    public static void main(String[] args) {
        WordBreakII.DPImpl breakII = new WordBreakII.DPImpl();
        System.out.println(breakII.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
//        System.out.println(breakII.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
//        System.out.println(breakII.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    public static class BfsImpl {

        static class Node {
            private String match;
            private String china;

            public Node(String match, String china) {
                this.match = match;
                this.china = china;
            }
        }

        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<Node> set = new HashSet<>();
            for (String s1 : wordDict) {
                if (s.startsWith(s1)) {
                    set.add(new Node(s.substring(s1.length()), s1));
                }
            }
            List<String> ans = new ArrayList<>();
            while (!set.isEmpty()) {
                Set<Node> nextSet = new HashSet<>();

                for (Node node : set) {
                    if (node.match.length() == 0) {
                        ans.add(node.china);
                        continue;
                    }
                    for (String s1 : wordDict) {
                        if (node.match.startsWith(s1)) {
                            nextSet.add(new Node(node.match.substring(s1.length()), node.china + " " + s1));
                        }
                    }
                }

                set = nextSet;
            }
            return ans;
        }

    }

    static class DPImpl {

        public List<String> wordBreak(String s, List<String> wordDict) {
            Map<Integer, List<String>> dp = new HashMap<>();
            dp.put(0, Collections.singletonList(""));

            Map<Integer, List<String>> wordMap = new HashMap<>();
            for (String s1 : wordDict) {
                List<String> wordList = wordMap.getOrDefault(s1.length(), new ArrayList<>());
                wordList.add(s1);
                wordMap.put(s1.length(), wordList);
            }
            Set<Map.Entry<Integer, List<String>>> wordEntrySet = wordMap.entrySet();
            for (int i = 1; i <= s.length(); i++) {
                String subString = s.substring(0, i);
                for (Map.Entry<Integer, List<String>> entry : wordEntrySet) {
                    if (dp.get(i - entry.getKey()) == null) continue;
                    for (String word : entry.getValue()) {
                        if (subString.endsWith(word)) {
                            List<String> list = dp.getOrDefault(i, new ArrayList<>());
                            for (String china : dp.get(i - word.length())) {
                                String prefix = china.length() > 0 ? (china + " ") : "";
                                list.add(prefix + word);
                            }
                            dp.put(i, list);
                            break;
                        }
                    }
                }
                /*for (String word : wordDict) {
                    if (subString.endsWith(word) && dp.get(i - word.length()) != null) {
                        List<String> list = dp.getOrDefault(i, new ArrayList<>());
                        for (String china : dp.get(i - word.length())) {
                            String prefix = china.length() > 0 ? (china + " ") : "";
                            list.add(prefix + word);
                        }
                        dp.put(i, list);
                    }
                }*/
            }
            return dp.getOrDefault(s.length(), Collections.emptyList());
        }

    }

}
