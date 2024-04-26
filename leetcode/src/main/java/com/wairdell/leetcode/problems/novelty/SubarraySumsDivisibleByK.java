package com.wairdell.leetcode.problems.novelty;

/**
 * date   : 2024/4/25 13:32
 * desc   : 和可被 K 整除的子数组 https://leetcode.cn/problems/subarray-sums-divisible-by-k
 */
public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {
        SubarraySumsDivisibleByK divisible = new SubarraySumsDivisibleByK();
        System.out.println(divisible.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(divisible.subarraysDivByK(new int[]{-5}, 5));
    }

    public int subarraysDivByK(int[] nums, int k) {
        int[] residueCnt = new int[k];
        residueCnt[0] = 1;
        int cnt = 0;
        int sum = 0;
        //连续子数组能被K整除， 转化为当前0~n相加的和对K取余 - 之前同样的余数的0~m相加和
        //然后之前同于余数的子数组有多少个，[0~n, n]之间的能被K整除就有多少个
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int residue = sum % k;
            if (residue < 0) residue += k;
            cnt += residueCnt[residue];
            residueCnt[residue]++;
        }
        return cnt;
    }

}
