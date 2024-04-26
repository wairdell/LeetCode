package com.wairdell.leetcode.problems.novelty;

/**
 * date   : 2024/4/25 11:28
 * desc   : 可被三整除的最大和 https://leetcode.cn/problems/greatest-sum-divisible-by-three
 */
public class GreatestSumDivisibleByThree {

    public static void main(String[] args) {
        GreatestSumDivisibleByThree divisible = new GreatestSumDivisibleByThree();

//        System.out.println(divisible.maxSumDivThree(new int[]{3, 6, 5, 1, 8}));

//        System.out.println(divisible.maxSumDivThree(new int[]{2, 6, 2, 2, 7}));

        System.out.println(divisible.maxSumDivThree(new int[]{2, 6, 2, 2, 7}));
        //7 + 6 + 2
    }

    public int maxSumDivThree(int[] nums) {
        int minRem1 = Integer.MAX_VALUE / 2;
        int minRem2 = Integer.MAX_VALUE / 2;
        int maxRem1 = -1;
        int maxRem2 = -1;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        //可被三整除的最大和转化为 max(相加相加和最大余数为2的数 - 最小余数为2的数, 相加相加和最大余数1的数 - 最小余数为1的数, 被2整除的数)
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int remI = num % 3;
            if (remI == 1) {
                if (minRem1 + num < minRem2) {
                    minRem2 = minRem1 + num;
                }
                minRem1 = Math.min(minRem1, num);
            } else if (remI == 2) {
                if (minRem2 + num < minRem1) {
                    minRem1 = minRem2 + num;
                }
                minRem2 = Math.min(minRem2, num);
            }

            sum += num;
//            min = Math.max(min, num);

            int remSum = sum % 3;
            if (remSum == 0) {
                max = Math.max(sum, max);
            } else if (remSum == 1) {
                maxRem1 = Math.max(sum, maxRem1);
            } else {
                maxRem2 = Math.max(sum, maxRem2);
            }
        }
        return Math.max(Math.max(max, maxRem2 - minRem2), maxRem1 - minRem1);
    }

}
