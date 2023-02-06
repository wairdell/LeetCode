package com.wairdell.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/1 16:07
 * desc   : 括号生成 https://leetcode.cn/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 1) {
            result.add("()");
            return result;
        }
        List<String> parenthesis = generateParenthesis(n - 1);
        for (String s : parenthesis) {
            if (!result.contains("(" + s + ")")) {
                result.add("(" + s + ")");
            }
            if (!result.contains(s + "()")) {
                result.add(s + "()");
            }
            if (!result.contains("()" + s)) {
                result.add("()" + s);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(4));
    }

}
