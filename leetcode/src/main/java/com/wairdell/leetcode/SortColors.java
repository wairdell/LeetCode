package com.wairdell.leetcode;

import java.util.Arrays;

/**
 * author : fengqiao
 * date   : 2023/2/8 11:04
 * desc   : 颜色分类 https://leetcode.cn/problems/sort-colors/
 */
public class SortColors {

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

    public static void main(String[] args) {
        int[] input = new int[]{2, 0, 2, 1, 1, 0};
        new SortColors().sortColors(input);
        System.out.println("result = " + Arrays.toString(input));

        input = new int[]{2, 11, 76, 12, 89, 0, 3, 8, 1};
        new SortColors().sortColors(input);
        System.out.println("result = " + Arrays.toString(input));
    }

}
