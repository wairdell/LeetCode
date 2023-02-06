package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/2 11:40
 * desc   : 寻找两个正序数组的中位数 https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n = 0;
        int lastNum = 0;
        int num;
        int sumLength = nums1.length + nums2.length;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    num = nums1[i];
                    i++;
                } else {
                    num = nums2[j];
                    j++;
                }
            } else if (i < nums1.length) {
                num = nums1[i];
                i++;
            } else {
                num = nums2[j];
                j++;
            }
            n++;
            if (sumLength % 2 == 1) {
                if (n == sumLength / 2 + 1) {
                    return num;
                }
            } else {
                if (n == sumLength / 2 + 1) {
                    return (lastNum + num) / 2F;
                }
            }
            lastNum = num;
        }
        return 0f;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println("result = " + new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

}
