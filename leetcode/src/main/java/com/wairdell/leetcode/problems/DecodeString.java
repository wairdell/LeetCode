package com.wairdell.leetcode.problems;

/**
 * date   : 2024/5/9 17:14
 * desc   : 字符串解码 https://leetcode.cn/problems/decode-string
 */
public class DecodeString {

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a]2[bc]"));
        System.out.println(decodeString.decodeString("3[a2[c]]"));
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString.decodeString("abc3[cd]xyz"));
    }

    public String decodeString(String s) {
       return solve(s, 0).ret;
    }

    static class Pair {
        public String ret;
        public int pos;

        public Pair(String ret, int position) {
            this.ret = ret;
            this.pos = position;
        }
    }

    public Pair solve(String s, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        int num = 0;
        for (; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '[') {
                Pair pair = solve(s, i + 1);
                for (int j = 0; j < num; j++) {
                    stringBuilder.append(pair.ret);
                }
                num = 0;
                i = pair.pos;
            } else if (charAt == ']') {
                return new Pair(stringBuilder.toString(), i);
            } else if (charAt >= '0' && charAt <= '9') {
                num = num * 10 + (charAt - '0');
            } else {
                stringBuilder.append(charAt);
            }
        }
        return new Pair(stringBuilder.toString(), s.length());
    }

}
