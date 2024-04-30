package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/6 15:56
 * desc   : 相同分数的最大操作数目 I https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-i
 */
public class MaximumNumberOfOperationsWithTheSameScoreI {

    public static void main(String[] args) {
        MaximumNumberOfOperationsWithTheSameScoreI scoreI = new MaximumNumberOfOperationsWithTheSameScoreI();
        System.out.println(scoreI.maxOperations(new int[]{3, 2, 1, 4, 5}));
        System.out.println(scoreI.maxOperations(new int[]{3, 2, 6, 1, 4}));
        System.out.println(scoreI.maxOperations(new int[]{1, 1, 1, 1, 1, 1}));
    }

    public int maxOperations(int[] nums) {
        int ans = 1;
        int sum = nums[0] + nums[1];
        for (int i = 2; i <= nums.length - 2; i += 2) {
            if (sum == nums[i] + nums[i + 1]) {
                ans++;
            } else {
                return ans;
            }
        }
        return ans;
    }

}
