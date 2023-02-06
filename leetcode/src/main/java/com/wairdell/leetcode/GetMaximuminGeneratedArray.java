package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/2 10:38
 * desc   : 获取生成数组中的最大值 https://leetcode.cn/problems/get-maximum-in-generated-array/
 */
public class GetMaximuminGeneratedArray {

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] array = new int[n + 1];
        int max = 1;
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                array[i] = array[i / 2];
            } else {
                array[i] = array[i / 2] + array[i / 2 + 1];
            }
            max = Math.max(max, array[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new GetMaximuminGeneratedArray().getMaximumGenerated(7));
    }

}
