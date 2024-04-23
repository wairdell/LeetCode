package com.wairdell.leetcode.problems.algorithm.greedy;

/**
 * author : fengqiao
 * date   : 2023/2/2 14:27
 * desc   : 跳跃游戏 II https://leetcode.cn/problems/jump-game-ii/
 */
public class JumpGameII {

    public int jump(int[] nums) {
        //贪心算法
        int ans = 0;
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //某一阶段在起点位置和结束位置中求个最大坐标
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end) {
                //如果到达了某个阶段的终点坐标，将下一阶段的终点坐标更新为这个阶段求出的最大坐标
                end = maxPos;
                ans++;
            }
        }
        return ans;
    }

    /*public int jump(int[] nums) {
//        System.out.println("\n" + Arrays.toString(nums) + " => ");
        int[] weights = new int[nums.length];
        int maxWeight = nums[0];
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                weights[i] = 0;
            } else {
                weights[i] = i + nums[i];
            }
            if (maxWeight >= i) {
                maxWeight = Math.max(maxWeight, weights[i]);
            }
        }
        if (maxWeight < nums.length - 1) {
            return 0;
        }
        if (nums[0] >= nums.length) {
            return 1;
        }
        int step = 0;
        int result = 1;
        while (step + nums[step] < nums.length - 1) {
//            System.out.println(step);
            int max = 0;
            int temp = step;
            result++;
            for (int i = 1; i <= nums[temp]; i++) {
                int realIndex = temp + i;
                if (weights[realIndex] > max) {
                    max = weights[realIndex];
                    step = realIndex;
                }
            }
//            System.out.print(step + " ");
        }
//        System.out.println("return");
        return result;
    }*/

    public static void main(String[] args) {

//        System.out.println(new JumpGameII().jump(new int[]{0}));
//        System.out.println(new JumpGameII().jump(new int[]{1, 0, 0, 4}));
//        System.out.println("result = " + new JumpGameII().jump(new int[]{2, 1}));
//        System.out.println("result = " + new JumpGameII().jump(new int[]{2, 3, 0, 1, 4}));
//        System.out.println("result = " + new JumpGameII().jump(new int[]{1, 1, 3}));
//        System.out.println("result = " + new JumpGameII().jump(new int[]{1, 2, 3}));
//        System.out.println("result = " + new JumpGameII().jump(new int[]{1, 3, 2}));
        System.out.println("result = " + new JumpGameII().jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }

}
