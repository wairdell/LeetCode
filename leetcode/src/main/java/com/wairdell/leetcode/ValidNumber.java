package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/2 17:59
 * desc   : 有效数字 https://leetcode.cn/problems/valid-number/
 */
public class ValidNumber {

    public boolean isInteger(String s) {
        if (s.isEmpty()) {
            return false;
        }
        int i = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            i = 1;
        }
        for (;i < s.length() - 1; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return s.charAt(s.length() - 1) >= '0' && s.charAt(s.length() - 1) <= '9';
    }

    public boolean isNumber(String s) {
        boolean alreadyDecimalPoint = false;
        boolean hasNumber = false;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '-' || charAt == '+') {
                if (i != 0) {
                    return false;
                }
            } else if (charAt >= '0' && charAt <= '9') {
                hasNumber = true;
            } else if (charAt == '.') {
                if (alreadyDecimalPoint) {
                    return false;
                }
                alreadyDecimalPoint = true;
            } else if (charAt == 'e' || charAt == 'E') {
                if (hasNumber) {
                    return isInteger(s.substring(i + 1));
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return hasNumber;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new ValidNumber().isNumber("2"));
        System.out.println("result = " + new ValidNumber().isNumber("0089"));
        System.out.println("result = " + new ValidNumber().isNumber("-0.1"));
        System.out.println("result = " + new ValidNumber().isNumber("+3.14"));
        System.out.println("result = " + new ValidNumber().isNumber("4."));
        System.out.println("result = " + new ValidNumber().isNumber("-.9"));
        System.out.println("result = " + new ValidNumber().isNumber("2e10"));
        System.out.println("result = " + new ValidNumber().isNumber("-90E3"));
        System.out.println("result = " + new ValidNumber().isNumber("3e+7"));
        System.out.println("result = " + new ValidNumber().isNumber("+6e-1"));
        System.out.println("result = " + new ValidNumber().isNumber("53.5e93"));
        System.out.println("result = " + new ValidNumber().isNumber("-123.456e789"));

        System.out.println("---------------------------------");
        System.out.println("result = " + new ValidNumber().isNumber("abc"));
        System.out.println("result = " + new ValidNumber().isNumber("1a"));
        System.out.println("result = " + new ValidNumber().isNumber("e3"));
        System.out.println("result = " + new ValidNumber().isNumber("99e2.5"));
        System.out.println("result = " + new ValidNumber().isNumber("--6"));
        System.out.println("result = " + new ValidNumber().isNumber("-+3"));
        System.out.println("result = " + new ValidNumber().isNumber("95a54e53"));
        System.out.println("result = " + new ValidNumber().isNumber("+."));

    }

}
