package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/6 17:29
 * desc   : N 字形变换 https://leetcode.cn/problems/zigzag-conversion/
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        byte[] bytes = s.getBytes();
        int divisor = Math.max(numRows + (numRows - 2), 1);
        for (int i = 0; i < bytes.length; i++) {
            int remainder = i % divisor;
            if (remainder >= numRows) {
                rows[divisor - remainder].append(((char) bytes[i]));
            } else {
                rows[remainder].append(((char) bytes[i]));
            }

        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            result.append(rows[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String result = new ZigzagConversion().convert("PAYPALISHIRING", 3);
        System.out.println(result.equals("PAHNAPLSIIGYIR"));

        result = new ZigzagConversion().convert("PAYPALISHIRING", 4);
        System.out.println(result.equals("PINALSIGYAHRPI"));

        result = new ZigzagConversion().convert("A", 1);
        System.out.println(result.equals("A"));
    }

}
