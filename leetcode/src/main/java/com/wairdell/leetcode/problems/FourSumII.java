package com.wairdell.leetcode.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date   : 2024/4/26 10:02
 * desc   : 四数相加 II https://leetcode.cn/problems/4sum-ii/
 */
public class FourSumII {

    public static void main(String[] args) {
        FourSumII fourSumII = new FourSumII();
        System.out.println(fourSumII.fourSumCount(new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2}));

        System.out.println(fourSumII.fourSumCount(new int[]{0},
                new int[]{0},
                new int[]{0},
                new int[]{0}));
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                if (cntMap.containsKey(sum)) {
                    cntMap.put(sum, cntMap.get(sum) + 1);
                } else {
                    cntMap.put(sum, 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums3[i] + nums4[j];
                ans += cntMap.getOrDefault(-sum, 0);
            }
        }
        return ans;
    }

}
