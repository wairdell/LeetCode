package com.wairdell.leetcode.exapmle;

import java.util.Arrays;

/**
 * date   : 2024/4/12 10:21
 * desc   : 插入排序（https://www.hello-algo.com/chapter_sorting/insertion_sort/）
 *          我们在未排序区间选择一个基准元素，将该元素与其左侧已排序区间的元素逐一比较大小，并将该元素插入到正确的位置。
 */
public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] input = {4, 1, 3, 2};
        insertionSort.insertionSort(input);
        System.out.println(Arrays.toString(input));

        int[] input2 = {4, 5, 9, 7, 3, 2};
        insertionSort.insertionSort(input2);
        System.out.println(Arrays.toString(input2));
    }

    void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1, cache = nums[i];
            while (j >= 0 && nums[j] > cache) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = cache;
        }
    }

}
