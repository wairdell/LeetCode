package com.wairdell.leetcode;

import java.util.Arrays;

/**
 * author : fengqiao
 * date   : 2023/2/8 11:30
 * desc   : 合并两个有序数组 https://leetcode.cn/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //1, 2, 3, 0, 0, 0
        //2, 5, 3
        int nums2I = 0;
        for (int i = 0; i < m + nums2I; i++) {
            if (nums2I >= n) {
                break;
            }
            if (nums2[nums2I] <= nums1[i]) {
                for (int j = m + nums2I; j > i; j--) {
                    nums1[j] = nums1[j - 1];
                }
                nums1[i] = nums2[nums2I];
                nums2I++;
            }
        }
        for (int i = nums2I; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        new MergeSortedArray().merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println("result = " + Arrays.toString(nums1));

        nums1 = new int[]{1};
        new MergeSortedArray().merge(nums1, 1, new int[]{}, 0);
        System.out.println("result = " + Arrays.toString(nums1));

        nums1 = new int[]{0};
        new MergeSortedArray().merge(nums1, 0, new int[]{1}, 1);
        System.out.println("result = " + Arrays.toString(nums1));

        nums1 = new int[]{4, 0, 0, 0, 0, 0};
        new MergeSortedArray().merge(nums1, 1, new int[]{1, 2, 3, 5, 6}, 5);
        System.out.println("result = " + Arrays.toString(nums1));
    }

}
