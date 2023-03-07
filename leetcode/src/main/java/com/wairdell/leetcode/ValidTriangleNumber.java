package com.wairdell.leetcode;

import java.util.Arrays;

/**
 * author : fengqiao
 * date   : 2023/3/7 16:32
 * desc   : https://leetcode.cn/problems/valid-triangle-number/submissions/ 有效三角形的个数
 */
public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int firstEdge = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int secondEdge = nums[j];
                int k = j + 1;
                for (; k < nums.length; k++) {
                    int thirdEdge = nums[k];
                    if (firstEdge + secondEdge > thirdEdge && firstEdge + thirdEdge > secondEdge && thirdEdge + secondEdge > firstEdge) {
                        result++;
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ValidTriangleNumber().triangleNumber(new int[]{2, 2, 3, 4}));
        System.out.println(new ValidTriangleNumber().triangleNumber(new int[]{4, 2, 3, 4}));
        System.out.println(new ValidTriangleNumber().triangleNumber(new int[]{24, 3, 82, 22, 35, 84, 19}));
    }

}
