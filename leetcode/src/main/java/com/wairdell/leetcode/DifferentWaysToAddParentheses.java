package com.wairdell.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import jdk.internal.net.http.common.Log;

/**
 * author : fengqiao
 * date   : 2023/2/7 16:32
 * desc   : 为运算表达式设计优先级 https://leetcode.cn/problems/different-ways-to-add-parentheses/
 */
public class DifferentWaysToAddParentheses {

    static class Impl {
        public List<Integer> diffWaysToCompute(String expression) {
            List<Object> parseResult = new ArrayList<>();
            int sum = 0;
            int pow = 1;
            for (int i = 0; i < expression.length(); i++) {
                char charAt = expression.charAt(i);
                if (charAt == '+' || charAt == '-' || charAt == '*') {
                    parseResult.add(sum);
                    parseResult.add(charAt);
                    pow = 1;
                    sum = 0;
                } else {
                    if (sum == 0) {
                        sum = charAt - '0';
                    } else {
                        sum = sum * pow + (charAt - '0');
                    }
                    if (i == expression.length() - 1) {
                        parseResult.add(sum);
                    }
                    pow *= 10;
                }
            }
            return diffWaysToCompute(parseResult, 0, parseResult.size());
        }

        public List<Integer> diffWaysToCompute(List<Object> parseResult, int start, int end) {
//        System.out.println(parseResult.subList(start, end));
            if (end - start == 1) {
                return Collections.singletonList(((Integer) parseResult.get(start)));
            } else if (end - start == 3) {
                Character symbol = (Character) parseResult.get(start + 1);
                Integer num1 = ((Integer) parseResult.get(start));
                Integer num2 = ((Integer) parseResult.get(start + 2));
                return Collections.singletonList(calculate(num1, num2, symbol));
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = start; i < end - 2; i += 2) {
                List<Integer> part1 = diffWaysToCompute(parseResult, start, i + 1);
                List<Integer> part2 = diffWaysToCompute(parseResult, i + 2, end);
                Character part2Symbol = (Character) parseResult.get(i + 1);
                arrayList.addAll(calculate(part1, part2, part2Symbol));
            }
            return arrayList;
        }

        public List<Integer> calculate(List<Integer> num1List, List<Integer> num2List, Character symbol) {
            ArrayList<Integer> list = new ArrayList<>();
            for (Integer integer1 : num1List) {
                for (Integer integer2 : num2List) {
                    list.add(calculate(integer1, integer2, symbol));
                }
            }
            return list;
        }

        public int calculate(Integer num1, Integer num2, Character symbol) {
            if (symbol.equals('+')) {
                return num1 + num2;
            } else if (symbol.equals('-')) {
                return num1 - num2;
            } else if (symbol.equals('*')) {
                return num1 * num2;
            } else {
                throw new RuntimeException();
            }
        }
    }

    static class DfsImpl {

        public List<Integer> diffWaysToCompute(String expression) {
            String nums = "";
            List<Integer> numList = new Stack<>();
            List<Character> operateList = new Stack<>();
            for (int i = 0; i <= expression.length(); i++) {
                if (i == expression.length()) {
                    numList.add(Integer.parseInt(nums));
                } else {
                    char charAt = expression.charAt(i);
                    if (charAt >= '0' && charAt <= '9') {
                        nums += charAt;
                    } else {
                        numList.add(Integer.parseInt(nums));
                        operateList.add(charAt);
                        nums = "";
                    }
                }
            }
            return dfs(numList, operateList, 0, numList.size() - 1, new HashMap<>());
        }

        private int calcWithOperate(int num, int num2, char symbol) {
            switch (symbol) {
                case '+':
                    return num + num2;
                case '-':
                    return num - num2;
                case '*':
                    return num * num2;
            }
            return 0;
        }

        private List<Integer> dfs(List<Integer> numList, List<Character> operateList, int l, int r, Map<String, List<Integer>> cache) {
            if (cache.containsKey(l + "," + r)) return cache.get(l + "," + r);
            if (l == r) return Collections.singletonList(numList.get(l));
            if (r - l == 1) return Collections.singletonList(calcWithOperate(numList.get(l), numList.get(r), operateList.get(l)));
            List<Integer> ans = new ArrayList<>();
            for (int i = l; i < r; i++) {
                List<Integer> prefixAns = dfs(numList, operateList, l, i, cache);
                List<Integer> suffixAns = dfs(numList, operateList, i + 1, r, cache);
                cache.put(l + "," + i, prefixAns);
                cache.put((i + 1) + "," + r, suffixAns);
                for (Integer prefix : prefixAns) {
                    for (Integer suffix : suffixAns) {
                        ans.add(calcWithOperate(prefix, suffix, operateList.get(i)));
                    }
                }
            }
            return ans;
        }

    }


    public static void main(String[] args) {
        DifferentWaysToAddParentheses.DfsImpl ways = new DifferentWaysToAddParentheses.DfsImpl();
//        System.out.println("result = " + ways.diffWaysToCompute("2-1-1"));// 2, 0
        /*
        2 * (3 - (4 * 5))
        2 * ((3-4) * 5)
        (2 * (3 - 4))*5
        ((2 * 3) - 4) *5
        (2 * 3) - (4 * 5)
         */
        System.out.println("result = " + ways.diffWaysToCompute("2*3-4*5")); //  -34, -10, -14, -10, 10
    }

}
