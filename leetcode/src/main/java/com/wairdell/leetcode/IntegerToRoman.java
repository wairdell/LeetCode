package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/7 11:05
 * desc   : 整数转罗马数字 https://leetcode.cn/problems/integer-to-roman/
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int digit = 0;
        while (num > 0) {
            int numi = num % 10;
            num /= 10;
            result.insert(0, numToRoman(numi, digit));
            digit++;
        }
        return result.toString();
    }

    private final String[] oneList = new String[]{"I", "X", "C", "M"};
    private final String[] fiveList = new String[]{"V", "L", "D"};

    public String numToRoman(int num, int digit) {
        String one = oneList[digit];
        String five = digit < fiveList.length ? fiveList[digit] : "";
        String ten = digit + 1 < oneList.length ? oneList[digit + 1] : "";
        if (num == 9) {
            return one + ten;
        } else if (num == 4) {
            return one + five;
        } else if (num >= 5) {
            StringBuilder res = new StringBuilder(five);
            for (int i = 0; i < num - 5; i++) {
                res.append(one);
            }
            return res.toString();
        } else {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < num; i++) {
                res.append(one);
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("result = " + new IntegerToRoman().intToRoman(3));
        System.out.println("result = " + new IntegerToRoman().intToRoman(4));
        System.out.println("result = " + new IntegerToRoman().intToRoman(9));
        System.out.println("result = " + new IntegerToRoman().intToRoman(58));
        System.out.println("result = " + new IntegerToRoman().intToRoman(1994));
        System.out.println("result = " + new IntegerToRoman().intToRoman(0));
    }

}
