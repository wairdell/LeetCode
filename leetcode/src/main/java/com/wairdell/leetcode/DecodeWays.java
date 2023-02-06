package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/3 14:56
 * desc   : 解码方法 https://leetcode.cn/problems/decode-ways/
 */
public class DecodeWays {

    public int numDecodings(String s) {
        boolean[][] match = new boolean[s.length()][s.length()];
        return numDecodings(s, 0, s.length(), match);
    }

    public int numDecodings(String s, int start, int end, boolean[][] match) {
//        System.out.println(s);
        if (match[start][end - 1]) {
            return 0;
        }
        match[start][end - 1] = true;
        if (s.startsWith("0")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 2) {
            if (s.startsWith("1")) {
                return 1 + numDecodings(s.substring(1), start + 1, end, match);
            } else if (s.startsWith("2") && (s.charAt(1) >= '0' && s.charAt(1) <= '6')) {
                return 1 + numDecodings(s.substring(1), start + 1, end, match);
            } else if ("00".equals(s)) {
                return 0;
            } else {
                return 1;
            }
        }
        int backPart = numDecodings(s.substring(1), start + 1, end, match);
        int frontPart = s.charAt(s.length() - 1) != '0' ? numDecodings(s.substring(0, s.length() - 1), start, end - 1, match) : 0;
        /*if (backPart > 0 && frontPart > 0) {
            return backPart + frontPart - 1;
        }*/
        return backPart + frontPart;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new DecodeWays().numDecodings("12"));
        System.out.println("result = " + new DecodeWays().numDecodings("226"));
        System.out.println("result = " + new DecodeWays().numDecodings("1201234"));
    }

}
