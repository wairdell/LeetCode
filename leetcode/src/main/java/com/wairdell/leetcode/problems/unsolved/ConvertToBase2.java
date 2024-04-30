package com.wairdell.leetcode.problems.unsolved;

/**
 * date   : 2024/4/28 9:40
 * desc   :
 */
public class ConvertToBase2 {

    public static void main(String[] args) {
        ConvertToBase2 convert = new ConvertToBase2();
        System.out.println(convert.baseNeg2(4));
    }

    public int exp(int n) {
        int cnt = 0;
        while (n > 0) {
            n = n >> 1;
            cnt++;
        }
        return cnt - 1;
    }

    public String baseNeg2(int n) {
        int ans = 0;
        /*int exp = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                if (exp % 2 == 0) {
                    ans += (1 << exp);
                } else {
                    ans += (1 << (exp + 1)) + (1 << exp);
                }
            }
            n = (n >> 1);
            exp++;
        }*/
        return Integer.toBinaryString(ans);
    }

}
