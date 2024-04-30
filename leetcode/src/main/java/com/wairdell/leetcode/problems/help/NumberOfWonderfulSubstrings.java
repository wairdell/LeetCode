package com.wairdell.leetcode.problems.help;

/**
 * date   : 2024/4/30 9:40
 * desc   : 最美子字符串的数目 https://leetcode.cn/problems/number-of-wonderful-substrings
 */
public class NumberOfWonderfulSubstrings {

    public static void main(String[] args) {
        System.out.println(new NumberOfWonderfulSubstrings().wonderfulSubstrings("aba"));
        System.out.println(new NumberOfWonderfulSubstrings().wonderfulSubstrings("aabb"));
        System.out.println(new NumberOfWonderfulSubstrings().wonderfulSubstrings("he"));
    }

    static class TimeOutImpl {

        public long wonderfulSubstrings(String word) {
            int[] prefix = new int[word.length() + 1];
            int mask = 0;
            int length = word.length();
            long ans = 0;
            for (int i = 0; i < length; i++) {
                int code = 1 << (word.charAt(i) - 'a');
                mask ^= code;
                for (int j = 0; j <= i; j++) {
                    int d = mask ^ prefix[j];
                    if (d == 0 || (d & (d - 1)) == 0) {
                        ans++;
                    }
                }
                prefix[i + 1] = mask;
            }
            return ans;
        }

    }

    public long wonderfulSubstrings(String word) {
        int mask = 0;
        int length = word.length();
        long ans = 0;
        long[] freq = new long[1 << 10];
        freq[0] = 1;
        for (int i = 0; i < length; i++) {
            int code = 1 << (word.charAt(i) - 'a');
            mask ^= code;
            //自身^自身=0 是满足条件的
            ans += freq[mask];
            for (int j = 0; j < 10; j++) {
                //只有一个奇数次，最终结果只有0000000001,0000000010,0000000100这些所有位只有一个1的二进制位，那么当前^什么数才能生成这些数字呢?
                // mask^某个数=0000000100，mask^0000000100=某个数
                ans += freq[mask ^ (1 << j)];
            }
            freq[mask]++;
        }
        return ans;
    }

}
