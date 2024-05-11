package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/11 15:59
 * desc   : 字符串相乘 https://leetcode.cn/problems/multiply-strings
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        MultiplyStrings multiply = new MultiplyStrings();
//        System.out.println(multiply.multiply("333333", "49"));
        System.out.println(multiply.multiply("0", "52"));
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        String ans = "0";
        int n = num2.length();
        for (int i = 0; i < n; i++) {
            int ibit = num2.charAt(n - 1 - i) - '0';
            if (ibit == 0) continue;
            StringBuilder bitMultiply = bitMultiple(num1, ibit);
            for (int j = 0; j < i; j++) {
                bitMultiply.append('0');
            }
            ans = add(ans, bitMultiply.toString());
        }
        return ans;
    }

    public StringBuilder bitMultiple(String bigNum, int bit) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int n = bigNum.length();
        for (int i = 0; i < n; i++) {
            int bigBit = bigNum.charAt(n - 1 - i) - '0';
            int multiple = bigBit * bit + carry;
            ans.insert(0, (multiple % 10));
            carry = multiple / 10;
        }
        if (carry > 0) {
            ans.insert(0, carry);
        }
        return ans;
    }

    public String add(String num1, String num2) {
        int carry = 0;
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        StringBuilder ans = new StringBuilder();
        int n1 = array1.length;
        int n2 = array2.length;
        int maxLen = Math.max(n1, n2);
        for (int i = 0; i < maxLen; i++) {
            int int1 = n1 > i ? array1[n1 - 1- i] - '0' : 0;
            int int2 = n2 > i ? array2[n2 - 1- i] - '0' : 0;
            int sum = int1 + int2 + carry;
            ans.insert(0, sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            ans.insert(0, carry);
        }
        return ans.toString();
    }

}
