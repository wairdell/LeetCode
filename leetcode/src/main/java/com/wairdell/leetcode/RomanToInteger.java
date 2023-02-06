package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/6 14:06
 * desc   : 罗马数字转整数 https://leetcode.cn/problems/roman-to-integer/
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        if (s.length() == 1) {
            return codeAt(s, 0);
        }
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            int codeAtLast = codeAt(s, i - 1);
            int codeAt = codeAt(s, i);
            if (codeAt > codeAtLast) {
                sum += (codeAt - codeAtLast);
                if (i == s.length() - 2) {
                    sum += codeAt(s, i + 1);
                }
                i++;
            } else {
                sum += codeAtLast;
                if (i == s.length() - 1) {
                    sum += codeAt;
                }
            }
        }
        return sum;
    }

    public int codeAt(String s, int index) {
        char c = s.charAt(index);
        if (c == 'I') {
            return 1;
        } else if (c == 'V') {
            return 5;
        } else if (c == 'X') {
            return 10;
        } else if (c == 'L') {
            return 50;
        } else if (c == 'C') {
            return 100;
        } else if (c == 'D') {
            return 500;
        } else if (c == 'M') {
            return 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new RomanToInteger().romanToInt("III"));
        System.out.println("result = " + new RomanToInteger().romanToInt("IV"));
        System.out.println("result = " + new RomanToInteger().romanToInt("IX"));
        System.out.println("result = " + new RomanToInteger().romanToInt("LVIII"));
        System.out.println("result = " + new RomanToInteger().romanToInt("MCMXCIV"));
        System.out.println("result = " + new RomanToInteger().romanToInt("D"));
        //M CM XC IV
    }
}
