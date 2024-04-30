package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;

/**
 * date   : 2024/4/30 14:56
 * desc   : 按奇偶排序数组 https://leetcode.cn/problems/sort-array-by-parity
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        SortArrayByParity parity = new SortArrayByParity();
//        System.out.println(Arrays.toString(parity.sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(parity.sortArrayByParity(new int[]{0, 2, 4})));
    }

    private int compare(int i, int j) {
        if (i == j) return 0;
        boolean isNum1Odd = i % 2 != 0;
        boolean isNum2Odd = j % 2 != 0;
        if (isNum1Odd || isNum2Odd) {
            if (isNum1Odd && isNum2Odd) {
                return 0;
            } else if (isNum1Odd) {
                return 1;
            }
            return -1;
        }
        return i > j ? 1 : -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int[] partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i = l, less = l, greater = r;
        while (i <= greater) {
            int ret = compare(nums[i], pivot);
            if (ret < 0) {
                swap(nums, i++, less++);
            } else if (ret > 0) {
                swap(nums, i, greater--);
            } else {
                i++;
            }
        }
        return new int[]{less, greater};
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int[] ret = partition(nums, l, r);
        quickSort(nums, l, ret[0] - 1);
        quickSort(nums, ret[1] + 1, r);
    }

    public int[] sortArrayByParity(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

}
