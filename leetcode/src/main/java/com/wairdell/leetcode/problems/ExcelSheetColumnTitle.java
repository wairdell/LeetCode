package com.wairdell.leetcode.problems;

/**
 * date   : 2024/5/8 14:57
 * desc   : Excel表列名称 https://leetcode.cn/problems/excel-sheet-column-title
 */
public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        ExcelSheetColumnTitle title = new ExcelSheetColumnTitle();
//        System.out.println(title.convertToTitle(1));
//        System.out.println(title.convertToTitle(26));
        System.out.println(title.convertToTitle(27));
        System.out.println(title.convertToTitle(28));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            int rem = (columnNumber - 1) % 26 + 1;
            ans.insert(0, (char) ('A' + (rem - 1)));
            columnNumber = (columnNumber - rem) / 26;
        }
        return ans.toString();
    }

}
