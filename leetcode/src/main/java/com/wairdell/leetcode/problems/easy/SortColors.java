package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;

/**
 * author : fengqiao
 * date   : 2023/2/8 11:04
 * desc   : 颜色分类 https://leetcode.cn/problems/sort-colors/
 */
public class SortColors {

    static class Impl {

        public void sortColors(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
        }

        public void quickSort(int[] s, int l, int r) {
            if (l < r) {
                //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
                int i = l, j = r, x = s[l];
                while (i < j) {
                    // 从右向左找第一个小于x的数
                    while (i < j && s[j] >= x) {
                        j--;
                    }
                    if (i < j) {
                        s[i++] = s[j];
                    }
                    // 从左向右找第一个大于等于x的数
                    while (i < j && s[i] < x) {
                        i++;
                    }
                    if (i < j) {
                        s[j--] = s[i];
                    }
                }
                s[i] = x;
                // 递归调用
                quickSort(s, l, i - 1);
                quickSort(s, i + 1, r);
            }
        }

    }

    static class ImplNew {

        public void sortColors(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        void quickSort(int[] nums, int left, int right) {
            if (left >= right) return;
            int less = left, i = left, greater = right;
            int pivot = nums[left];
            while (i <= greater) {
                if (nums[i] < pivot) {
                    swap(nums, i++, less++);
                } else if (nums[i] > pivot) {
                    swap(nums, i, greater--);
                } else {
                    i++;
                }
            }
            quickSort(nums, left, less - 1);
            quickSort(nums, greater + 1, right);
        }

    }


    public static void main(String[] args) {
        int[] input = new int[]{2, 0, 2, 1, 1, 0};
        SortColors.ImplNew sortColors = new SortColors.ImplNew();

        sortColors.sortColors(input);
        System.out.println("result = " + Arrays.toString(input));// [0, 0, 1, 1, 2, 2]

        input = new int[]{2, 11, 76, 12, 89, 0, 3, 8, 1};
        sortColors.sortColors(input);
        System.out.println("result = " + Arrays.toString(input));// [0, 1, 2, 3, 8, 11, 12, 76, 89]
    }

}
