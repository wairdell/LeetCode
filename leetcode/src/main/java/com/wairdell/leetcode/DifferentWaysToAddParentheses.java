package com.wairdell.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/7 16:32
 * desc   : 为运算表达式设计优先级 https://leetcode.cn/problems/different-ways-to-add-parentheses/
 */
public class DifferentWaysToAddParentheses {

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

    public static void main(String[] args) {
        System.out.println("result = " + new DifferentWaysToAddParentheses().diffWaysToCompute("2-1-1"));
        /*
        2 * (3 - (4 * 5))
        2 * ((3-4) * 5)
        (2 * (3 - 4))*5
        ((2 * 3) - 4) *5
        (2 * 3) - (4 * 5)
         */
        System.out.println("result = " + new DifferentWaysToAddParentheses().diffWaysToCompute("2*3-4*5"));
    }

}
