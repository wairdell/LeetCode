package com.wairdell.leetcode;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * author : fengqiao
 * date   : 2023/2/23 17:39
 * desc   : 电话号码的字母组合 https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<String, List<String>> numberLettersMap = new HashMap<>();
        numberLettersMap.put("2", Arrays.asList("a", "b", "c"));
        numberLettersMap.put("3", Arrays.asList("d", "e", "f"));
        numberLettersMap.put("4", Arrays.asList("g", "h", "i"));
        numberLettersMap.put("5", Arrays.asList("j", "k", "l"));
        numberLettersMap.put("6", Arrays.asList("m", "n", "o"));
        numberLettersMap.put("7", Arrays.asList("p", "q", "r", "s"));
        numberLettersMap.put("8", Arrays.asList("t", "u", "v"));
        numberLettersMap.put("9", Arrays.asList("w", "x", "y", "z"));
        List<String> result = new ArrayList<>();
        result.add("");
        List<String> lastList = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            List<String> lettersList = numberLettersMap.get(digits.substring(i, i + 1));
            lastList.clear();
            lastList.addAll(result);
            result.clear();
            for (String s1 : lastList) {
                for (String s : lettersList) {
                    result.add(s1 + s);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("2"));
    }

}
