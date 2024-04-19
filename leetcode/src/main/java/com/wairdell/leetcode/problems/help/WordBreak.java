package com.wairdell.leetcode.problems.help;

import java.util.Arrays;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/1 18:08
 * desc   : 单词拆分 https://leetcode.cn/problems/word-break/
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] mapping = new boolean[s.length() + 1];
        mapping[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                //判断子串是否包含(0~n的子串是否包含可以拆解成 0~m~n, 再判断是否包含 n~m 和 m~n)
                if (mapping[j] && wordDict.contains(s.substring(j, i))) {
                    mapping[i] = true;
                }
            }
        }
        return mapping[s.length()];
    }

    /*public boolean wordBreak(String s, List<String> wordDict) {
        return dp(s, wordDict);
    }

    private boolean dp(String s, List<String> wordDict) {
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String substring = s.substring(word.length());
                if (substring.length() == 0) {
                    return true;
                } else {
                    if (dp(substring, wordDict)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }*/

    public static void main(String[] args) {
        System.out.println("result = " + new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println("result = " + new WordBreak().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println("result = " + new WordBreak().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println("result = " + new WordBreak().wordBreak("cars", Arrays.asList("car","ca","rs")));
        /*System.out.println("result = " + new WordBreak().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));*/
    }

}
