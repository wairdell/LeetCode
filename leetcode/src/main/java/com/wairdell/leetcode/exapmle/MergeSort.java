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
        // 左子数组区间为 [left, mid], 右子数组区间为 [mid+1, right]
        // 创建一个临时数组 tmp ，用于存放合并后的结果
        int[] temp = new int[right - left + 1];
        // 初始化左子数组和右子数组的起始索引
        int i = left, j = mid + 1, k = 0;
        // 当左右子数组都还有元素时，进行比较并将较小的元素复制到临时数组中
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 将左子数组和右子数组的剩余元素复制到临时数组中
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // 将临时数组 tmp 中的元素复制回原数组 nums 的对应区间
        for (int z = 0; z < temp.length; z++) {
            nums[left + z] = temp[z];
        }
    }

    void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;// 计算中点

        // 划分阶段
        mergeSort(nums, left, mid);// 递归左子数组
        mergeSort(nums, mid + 1, right);// 递归右子数组

        // 合并阶段
        merge(nums, left, mid, right);
    }

}
