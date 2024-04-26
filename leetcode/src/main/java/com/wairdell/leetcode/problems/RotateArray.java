package com.wairdell.leetcode.problems;

import java.util.Arrays;

/**
 * date   : 2024/4/26 13:57
 * desc   : 轮转数组 https://leetcode.cn/problems/rotate-array
 */
public class RotateArray {

    public static void main(String[] args) {
        RotateArray array = new RotateArray();
        int[] nums = new int[300];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        array.rotate(nums, 290);
        System.out.println(Arrays.toString(nums));
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = n - k % n;
        for (int i = 0; i < nums.length - 1; i++) {
            int j = (i + k) % n;
            if (j < i) {
                if (i - j > k) {
                    int nk = (i - j) / k;
                    j = (j + nk * k) % n;
                } else {
                    j = (j + k * (i / (n - k))) %n;
                }
            }
            swap(nums, i, j);
        }
    }

}
