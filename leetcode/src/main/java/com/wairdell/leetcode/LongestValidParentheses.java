package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/1 15:27
 * desc   : 最长有效括号 https://leetcode.cn/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int[] dp = new int[s.length()];
        byte[] chars = s.getBytes();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    //一组元素最少两个数 '(' + ')'
                    //和前面一个元素直接成为一组()，则最大有数是(当前成为一组的两个数 + 上一个组元素(i - 2)形成的最大有效数)
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && chars[i - dp[i - 1] - 1] == '(') {
                    //不能和前一个元素成为一组(), 则尝试把前一个元素成为的一组再包裹起来形成'(上一组元素)'结构的大组。
                    // chars[i - dp[i - 1] - 1] == '(' 是判断是否能将上一组元素包括成为大的一组元素
                    //加上 dp[i - dp[i] - 2] 则是成为一个大组后可以和这个大组的前一组元素成为最大有效数
                    dp[i] = (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
                maxLen = Math.max(dp[i], maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("(() result = " + new LongestValidParentheses().longestValidParentheses("(()"));
        System.out.println("()(() result = " + new LongestValidParentheses().longestValidParentheses("()(()"));
        System.out.println(")()()) result = " + new LongestValidParentheses().longestValidParentheses(")()())"));
        System.out.println("()(() result = " + new LongestValidParentheses().longestValidParentheses("()(()"));
        System.out.println("()(()) result = " + new LongestValidParentheses().longestValidParentheses("()(())"));
        System.out.println("(()(((() result = " + new LongestValidParentheses().longestValidParentheses("(()(((()"));
        System.out.println("(()()) result = " + new LongestValidParentheses().longestValidParentheses("(()())"));
    }

}
