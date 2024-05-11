package com.wairdell.leetcode.problems.unsolved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * date   : 2024/5/7 16:04
 * desc   : 最长递增子序列的个数 https://leetcode.cn/problems/number-of-longest-increasing-subsequence
 */
public class NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence subsequence = new NumberOfLongestIncreasingSubsequence();
//        System.out.println(subsequence.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
//        System.out.println(subsequence.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
//        System.out.println(subsequence.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
//        System.out.println(subsequence.findNumberOfLIS(new int[]{-100, -99, -98, -97, -96, -96}));
        System.out.println(subsequence.findNumberOfLIS(new int[]{26, 72, 68, 8, -91, -89, -15, 62, 61, 96, -70, 89, -72, 69, 3}));//6
//        System.out.println(subsequence.findNumberOfLIS(new int[]{76, -54, -43, 56, -40, -21, -63, -98, -63, -92, -26, 28, 68, -94, -90}));//2
        //1 2 4 5 7
        //1 2 3 5 7
        //1 2 3 4 7
    }

    public int findNumberOfLIS(int[] nums) {
        int max = 0;
        int[] cnt = new int[nums.length];
        int ans = 0;
        Map<Integer, List<Integer>> cntMap = new HashMap<>();
        cntMap.put(0, Collections.singletonList((int) -(10e6 + 1)));
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] > nums[i - 1]) {
                cnt[i] = cnt[i - 1] + 1;
            } else {
                cnt[i] = 1;
                int j = i - 1;
                while (j >= 0) {
                    if (nums[i] > nums[j]) {
                        cnt[i] = cnt[j] + 1;
                    } else if (nums[i] == nums[j]) {
                        cnt[i] = cnt[j];
                        break;
                    }
                    j--;
                }
            }
            List<Integer> previousList = cntMap.get(cnt[i] - 1);
            List<Integer> currentList = cntMap.getOrDefault(cnt[i], new ArrayList<>());
            for (Integer previous : previousList) {
                if (nums[i] > previous) {
                    currentList.add(nums[i]);
                }
            }
            cntMap.put(cnt[i], currentList);
            if (cnt[i] >= max) {
                max = cnt[i];
                ans = currentList.size();
            }
        }
        return ans;
    }

}
