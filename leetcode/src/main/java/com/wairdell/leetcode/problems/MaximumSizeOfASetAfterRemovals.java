package com.wairdell.leetcode.problems;

import java.util.HashSet;

/**
 * date   : 2024/5/6 15:33
 * desc   : 移除后集合的最多元素数 https://leetcode.cn/problems/maximum-size-of-a-set-after-removals
 */
public class MaximumSizeOfASetAfterRemovals {

    public static void main(String[] args) {
        MaximumSizeOfASetAfterRemovals removals = new MaximumSizeOfASetAfterRemovals();
//        System.out.println(removals.maximumSetSize(new int[]{1, 2, 1, 2}, new int[]{1, 1, 1, 1}));
        System.out.println(removals.maximumSetSize(new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3, 2, 3, 2, 3}));
        System.out.println(removals.maximumSetSize(new int[]{1, 1, 2, 2, 3, 3}, new int[]{4, 4, 5, 5, 6, 6}));
    }


    public int maximumSetSize(int[] nums1, int[] nums2) {
        int ans = 0;
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums1) {
            numSet.add(num);
        }
        ans = Math.min(numSet.size(), nums1.length / 2);
        int num1Size = numSet.size();

        HashSet<Integer> num2Set = new HashSet<>();
        for (int num : nums2) {
            if (numSet.contains(num)) {
                if (!num2Set.contains(num) && num1Size > nums1.length / 2) {
                    num1Size--;
                    num2Set.add(num);
                }
            } else {
                num2Set.add(num);
            }
        }
        ans += Math.min(num2Set.size(), nums2.length / 2);
        return ans;
    }

}
