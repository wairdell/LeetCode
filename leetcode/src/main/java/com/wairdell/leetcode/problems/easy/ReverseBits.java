package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/21 11:36
 * desc   : 颠倒二进制位 https://leetcode.cn/problems/reverse-bits
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) + (n & 1);
            n = (n >> 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        ReverseBits bits = new ReverseBits();
//        System.out.println(bits.reverseBits(0b110));
//        System.out.println(bits.reverseBits(0b100));
        System.out.println(bits.reverseBits(0b000001));
        System.out.println(bits.reverseBits(-3));
        System.out.println(bits.reverseBits(0b00000010100101000001111010011100));
        System.out.println(bits.reverseBits(0b11111111111111111111111111111101));
    }

}
