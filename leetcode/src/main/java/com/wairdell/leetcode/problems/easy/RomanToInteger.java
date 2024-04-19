package com.wairdell.leetcode.problems.easy;

/**
 * author : fengqiao
 * date   : 2023/2/6 14:06
 * desc   : 罗马数字转整数 https://leetcode.cn/problems/roman-to-integer/
 */
public class RomanToInteger {

    class Impl {

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
    }

    class ImplNew {

        public int romanToInt(String s) {
            int sum = 0;
            int previous = 0;
            for (int i = 0; i < s.length(); i++) {
                int value = codeAt(s, i);
                if (previous == 0) {
                    previous = value;
                    continue;
                }
                if (previous < value) {
                    sum += (value - previous);
                    previous = 0;
                } else {
                    sum += previous;
                    previous = value;
                }
            }
            sum += previous;
            return sum;
        }


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
//        RomanToInteger.Impl romanToInteger = new RomanToInteger().new Impl();

        RomanToInteger.ImplNew romanToInteger = new RomanToInteger().new ImplNew();
        System.out.println("result = " + romanToInteger.romanToInt("III"));//3
        System.out.println("result = " + romanToInteger.romanToInt("IV"));//4
        System.out.println("result = " + romanToInteger.romanToInt("IX"));//9
        System.out.println("result = " + romanToInteger.romanToInt("LVIII"));//58
        System.out.println("result = " + romanToInteger.romanToInt("MCMXCIV"));//1994
        System.out.println("result = " + romanToInteger.romanToInt("D"));//500
        //M CM XC IV
    }
}
