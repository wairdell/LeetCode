package com.wairdell.leetcode.exapmle;

import java.util.Arrays;

/**
 * date   : 2024/4/12 10:38
 * desc   : 归并排序（https://www.hello-algo.com/chapter_sorting/merge_sort/）
 *          1.划分阶段：通过递归不断地将数组从中点处分开，将长数组的排序问题转换为短数组的排序问题。
 *          2.合并阶段：当子数组长度为 1 时终止划分，开始合并，持续地将左右两个较短的有序数组合并为一个较长的有序数组，直至结束。
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] input = {4, 1, 3, 2};
        mergeSort.mergeSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));

        int[] input2 = {4, 5, 9, 7, 3, 2};
        mergeSort.mergeSort(input2, 0, input2.length - 1);
        System.out.println(Arrays.toString(input2));
    }

    /* 合并左子数组和右子数组 */
    void merge(int[] nums, int left, int mid, int right) {
        int l = left, r = mid + 1, k = 0;
        int[] temp = new int[right - left + 1];
        while (l <= mid && r <= right) {
            if (nums[l] < nums[r]) {
                temp[k++] = nums[l++];
            } else {
                temp[k++] = nums[r++];
            }
        }
        while (l <= mid) {
            temp[k++] = nums[l++];
        }
        while (r <= right) {
            temp[k++] = nums[r++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }

    void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (right + left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

}
