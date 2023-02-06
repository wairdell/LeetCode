package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/6 11:15
 * desc   : 外观数列 https://leetcode.cn/problems/count-and-say/
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append(result.charAt(0));
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    stringBuilder.append(count);
                    stringBuilder.append(result.charAt(j - 1));
                    count = 1;
                }
            }
            stringBuilder.append(count);
            stringBuilder.append(result.charAt(result. length() - 1));
            result = stringBuilder.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new CountAndSay().countAndSay(1));
        System.out.println("result = " + new CountAndSay().countAndSay(2));
        System.out.println("result = " + new CountAndSay().countAndSay(3));
        System.out.println("result = " + new CountAndSay().countAndSay(4));
        System.out.println("result = " + new CountAndSay().countAndSay(5));
        System.out.println("result = " + new CountAndSay().countAndSay(6));
    }

}
