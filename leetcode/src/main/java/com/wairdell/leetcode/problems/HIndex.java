package com.wairdell.leetcode.problems;

/**
 * date   : 2024/4/26 15:56
 * desc   : H 指数 https://leetcode.cn/problems/h-index/
 */
public class HIndex {

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        System.out.println(hIndex.hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(hIndex.hIndex(new int[]{1, 3, 1}));
    }

    public int hIndex(int[] citations) {
        int[] cnt = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            cnt[Math.min(citations[i], citations.length)]++;
        }
        for (int i = citations.length; i > 0; i--) {
            if (i < citations.length) cnt[i] += cnt[i + 1];
            if (cnt[i] >= i) {
                return i;
            }
        }
        return 0;
    }

}
