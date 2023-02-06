package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/2 13:41
 * desc   : 盛最多水的容器 https://leetcode.cn/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int result = 0;
        while (start < end) {
            //容纳水的大小是 `左右两边的距离 * min(左边，右边)`,如果移动大的那边一定比原来的小，
            //因为就算移动到一个更大的但是因为是求两边的 min 值，最大还是之前小的那边，两边的距离又变小了，所以一定会比原来小
            if (height[start] < height[end]) {
                result = Math.max(result, (end - start) * height[start]);
                start++;
            } else {
                result = Math.max(result, (end - start) * height[end]);
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("result = " + new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println("result = " + new ContainerWithMostWater().maxArea(new int[]{1,1}));
    }

}
