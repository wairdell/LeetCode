package com.wairdell.leetcode.exapmle;

import java.util.Arrays;

/**
 * date   : 2024/4/12 16:59
 * desc   :
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] input = {4, 1, 3, 2};
        quickSort.quickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));

        int[] input2 = {4, 5, 9, 7, 3, 2};
        quickSort.quickSort(input2, 0, input2.length - 1);
        System.out.println(Arrays.toString(input2));
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int less = start, i = start, greater = end;
        int pivot = nums[start];
        while (i <= greater) {
            if (nums[i] < pivot) {
                swap(nums, i++, less++);
            } else if (nums[i] > pivot) {
                swap(nums, i, greater--);
            } else {
                i++;
            }
        }
        /*int l = start, r = end;
        while (l < r) {
            while (l < r && nums[r] >= nums[start]) {
                r--;
            }
            while (l < r && nums[l] <= nums[start]) {
                l++;
            }
            swap(nums, l, r);
        }
        swap(nums, start, l);*/
        quickSort(nums, start, less - 1);
        quickSort(nums, greater + 1, end);
    }

}
