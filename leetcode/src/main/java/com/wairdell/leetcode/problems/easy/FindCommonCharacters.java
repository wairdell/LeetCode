package com.wairdell.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * date   : 2024/5/13 16:16
 * desc   : 查找共用字符 https://leetcode.cn/problems/find-common-characters
 */
public class FindCommonCharacters {

    public static void main(String[] args) {
        FindCommonCharacters characters = new FindCommonCharacters();
        System.out.println(characters.commonChars(new String[]{"bella", "label", "roller"}));
    }

    public List<String> commonChars(String[] words) {
        int[][] wordCnts = new int['z' - 'a' + 1][words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                wordCnts[ch - 'a'][i]++;
            }
        }
        List<String> ans = new ArrayList<>();

        letter:
        for (int i = 0; i < wordCnts.length; i++) {
            int min = Integer.MAX_VALUE;
            int[] wordCnt = wordCnts[i];
            for (int j = 0; j < wordCnt.length; j++) {
                if (wordCnt[j] == 0) continue letter;
                min = Math.min(min, wordCnt[j]);
            }
            for (int k = 0; k < min; k++) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }

}
