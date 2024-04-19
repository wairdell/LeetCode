package com.wairdell.leetcode.exapmle;

import java.util.Arrays;

/**
 * date   : 2024/4/12 15:17
 * desc   : 堆排序(https://www.hello-algo.com/chapter_sorting/heap_sort/)
 */
public class HeapSort {

    void siftDown(int[] nums, int n, int i) {
        while (true) {
            int l = i * 2 + 1, r = i * 2 + 2, mark = i;
            if (l < n && nums[l] > nums[mark]) {
                mark = l;
            }
            if (r < n && nums[r] > nums[mark]) {
                mark = r;
            }
            if (mark == i) return;
            swap(nums, i, mark);
            i = mark;
        }

    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void heapSort(int[] nums) {
        for (int i = (nums.length - 2) / 2; i >= 0; i--) {
            siftDown(nums, nums.length, i);
        }
        for (int i = 1; i < nums.length; i++) {
            swap(nums, 0, nums.length - i);
            siftDown(nums, nums.length - i, 0);
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] input = {4, 1, 3, 2};
        heapSort.heapSort(input);
        System.out.println(Arrays.toString(input));

        int[] input2 = {4, 5, 9, 7, 3, 2};
        heapSort.heapSort(input2);
        System.out.println(Arrays.toString(input2));
    }

}
