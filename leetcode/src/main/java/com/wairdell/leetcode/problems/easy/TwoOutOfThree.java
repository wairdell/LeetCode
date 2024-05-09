package com.wairdell.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * date   : 2024/5/9 14:59
 * desc   : 至少在两个数组中出现的值 https://leetcode.cn/problems/two-out-of-three
 */
public class TwoOutOfThree {

    public static void main(String[] args) {
        TwoOutOfThree ofThree = new TwoOutOfThree();
        System.out.println(ofThree.twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3}));
        System.out.println(ofThree.twoOutOfThree(new int[]{3, 1}, new int[]{2, 3}, new int[]{1, 2}));
        System.out.println(ofThree.twoOutOfThree(new int[]{1, 2, 2}, new int[]{4, 3, 3}, new int[]{5}));
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] cnt = new int[101];
        int n = Math.max(nums1.length, nums2.length);
        int[][] allNums = new int[][]{nums1, nums2, nums3};
        n = Math.max(n, nums3.length);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < allNums.length; j++) {
                if (i < allNums[j].length) {
                    cnt[allNums[j][i]] |= (1 << j);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < cnt.length; i++) {
            //1 2 4
            if (cnt[i] == 3 || cnt[i] == 5 || cnt[i] == 6 || cnt[i] == 7) {
                ans.add(i);
            }
        }
        return ans;
    }

}
