package com.wairdell.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/1 16:07
 * desc   :
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        result.add("()");
        for (int i = 1; i < n; i++) {
            ArrayList<String> list = new ArrayList<>(result);
            result.clear();
            for (String s : list) {
                result.add("(" + s + ")");
                result.add(s + "()");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }

}
