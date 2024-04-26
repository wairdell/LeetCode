package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date   : 2024/4/25 18:27
 * desc   : 替换字符串中的括号内容 https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string
 */
public class EvaluateTheBracketPairsOfAString {

    public static void main(String[] args) {
        EvaluateTheBracketPairsOfAString pairs = new EvaluateTheBracketPairsOfAString();
        System.out.println(pairs.evaluate("(name)is(age)yearsold",
                Arrays.asList(Arrays.asList("name", "bob"), Arrays.asList("age", "two"))));

        System.out.println(pairs.evaluate("hi(name)",
                Arrays.asList(Arrays.asList("a", "b"))));

        System.out.println(pairs.evaluate("(a)(a)(a)aaa",
                Arrays.asList(Arrays.asList("a", "yes"))));
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> replaceMap = new HashMap<>();
        for (List<String> pair : knowledge) {
            replaceMap.put(pair.get(0), pair.get(1));
        }
        StringBuilder ans = new StringBuilder();
        char[] charArray = s.toCharArray();
        StringBuilder findKey = new StringBuilder();
        boolean isMatch = false;
        for (char ch : charArray) {
            switch (ch) {
                case '(':
                    isMatch = true;
                    break;

                case ')':
                    String key = findKey.toString();
                    if (replaceMap.containsKey(key)) {
                        ans.append(replaceMap.get(key));
                    } else {
                        ans.append('?');
                    }
                    findKey.delete(0, findKey.length());
                    isMatch = false;
                    break;

                default:
                    (isMatch ? findKey : ans).append(ch);
                    break;

            }
        }
        /*for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                isMatch = true;
            } else if (charArray[i] == ')') {
                String key = findKey.toString();
                if (replaceMap.containsKey(key)) {
                    ans.append(replaceMap.get(key));
                } else {
                    ans.append('?');
                }
                findKey.delete(0, findKey.length());
                isMatch = false;
            } else if (isMatch) {
                findKey.append(charArray[i]);
            } else {
                ans.append(charArray[i]);
            }
        }*/
        return ans.toString();
    }

}
