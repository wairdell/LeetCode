package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/11 16:36
 * desc   : 找出所有子集的异或总和再求和 https://leetcode.cn/problems/sum-of-all-subset-xor-totals
 */
public class SumOfAllSubsetXorTotals {

    public static void main(String[] args) {
        SumOfAllSubsetXorTotals totals = new SumOfAllSubsetXorTotals();
        System.out.println(totals.subsetXORSum(new int[]{1, 3}));
        System.out.println(totals.subsetXORSum(new int[]{5, 1, 6}));
        System.out.println(totals.subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
    }

    public int subsetXORSum(int[] nums) {
        /*int xor = 0;
        int ans = 0;
        int[] xorArray = new int[nums.length + 1];
        xorArray[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            for (int j = 0; j <= i; j++) {
                System.out.println((xor ^ xorArray[j]));
                ans += (xor ^ xorArray[j]);
            }
            xorArray[i + 1] = xor;
        }
        return ans;*/
        return subsetXORSum(nums, 0, 0);
    }

    public int subsetXORSum(int[] nums, int i, int xor) {
        if (i == nums.length) return xor;
        return subsetXORSum(nums, i + 1, xor) + subsetXORSum(nums, i + 1, xor ^ nums[i]);
    }

}
