package com.wairdell.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/1 16:07
 * desc   : 括号生成 https://leetcode.cn/problems/generate-parentheses/
 */
public class GenerateParenthesis {

//    public List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
//        if (n == 1) {
//            result.add("()");
//            return result;
//        }
//        List<String> parenthesis = generateParenthesis(n - 1);
//        for (String s : parenthesis) {
//            if (!result.contains("(" + s + ")")) {
//                result.add("(" + s + ")");
//            }
//            if (!result.contains(s + "()")) {
//                result.add(s + "()");
//            }
//            if (!result.contains("()" + s)) {
//                result.add("()" + s);
//            }
//        }
//        return result;
//    }

    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, 0, 0, "");
    }

    public List<String> generateParenthesis(int n, int close, int open, String prefix) {
        if (prefix.length() == n * 2) {
            return Collections.singletonList(prefix);
        }
        ArrayList<String> list = new ArrayList<>();
        if (open < n) {
            list.addAll(generateParenthesis(n, close, open + 1, prefix + "("));
        }
        if (close < open) {
            list.addAll(generateParenthesis(n, close + 1, open, prefix + ")"));
        }

        return list;
    }


    public static void main(String[] args) {
        //()
        System.out.println(new GenerateParenthesis().generateParenthesis(1));
        //(()), ()()
        System.out.println(new GenerateParenthesis().generateParenthesis(2));
        //((())), (())(), ()(()), (()()), ()()()
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
        System.out.println(new GenerateParenthesis().generateParenthesis(4));
    }

}
