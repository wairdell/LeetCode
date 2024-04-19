package com.wairdell.leetcode.problems.help;

/**
 * author : fengqiao
 * date   : 2023/2/6 11:29
 * desc   : 缺失的第一个正数 https://leetcode.cn/problems/first-missing-positive/
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                //只查找正数，将负数标识为不在范围的数
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                //用数组的下标来记录某个数已存在(存在则将这个下标上记录的数字改为负数)
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //正数则标识下标对应的数不存在
            if (num > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new FirstMissingPositive().firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println("result = " + new FirstMissingPositive().firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println("result = " + new FirstMissingPositive().firstMissingPositive(new int[]{1, 2, 3, 4}));
    }

}
