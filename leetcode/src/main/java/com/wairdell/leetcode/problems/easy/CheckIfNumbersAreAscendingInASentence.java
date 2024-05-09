package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/9 15:19
 * desc   : 检查句子中的数字是否递增
 */
public class CheckIfNumbersAreAscendingInASentence {

    public static void main(String[] args) {
        CheckIfNumbersAreAscendingInASentence ascending = new CheckIfNumbersAreAscendingInASentence();
        System.out.println(ascending.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println(ascending.areNumbersAscending("hello world 5 x 5"));
        System.out.println(ascending.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
        System.out.println(ascending.areNumbersAscending("4 5 11 26"));
    }

    public boolean areNumbersAscending(String s) {
        int previous = -1;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            boolean isNumber = charAt >= '0' && charAt <= '9';
            if (isNumber) {
                num = num * 10 + (charAt - '0');
            }
            if ((!isNumber || i == s.length() - 1) && num > 0) {
                if (num <= previous) {
                    return false;
                }
                previous = num;
                num = 0;
            }
        }
        /*int previous = -1;
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String group = m.group();
            int num = Integer.parseInt(group);
            if (previous >= num) return false;
            previous = num;
        }*/
        return true;
    }

}
