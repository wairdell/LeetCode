package com.wairdell.leetcode.problems.algorithm.greedy;

/**
 * author : fengqiao
 * date   : 2023/2/6 15:30
 * desc   : 跳跃游戏 https://leetcode.cn/problems/jump-game/
 */
public class JumpGame {

   /* public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int[] widget = new int[nums.length];
        for (int i = 0; i < widget.length; i++) {
            if (nums[i] > 0) {
                widget[i] = i + nums[i];
            } else {
//                widget[i] = i;
            }
        }
        int index = 0;
        while (index < nums.length && index + nums[index] < nums.length - 1) {
            int num = nums[index];
            int max = 0;
            int maxIndex = index;
            for (int i = 1; i <= num; i++) {
                if (widget[index + i] > max) {
                    max = widget[index + i];
                    maxIndex = index + i;
                }
            }
            if (max <= index + nums[index]) {
                return false;
            }
            index = maxIndex;
        }
        return true;
    }*/

    static class Impl {
        public boolean canJump(int[] nums) {
            //使用贪心算法
            int distance = nums.length - 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (i + nums[i] >= distance) {
                    distance = i;
                }
            }
            return distance == 0;
        }
    }

    static class ImplNew {

        public boolean canJump(int[] nums) {
            if (nums.length == 1) return true;
            int max = nums[0];
            for (int i = 1; i <= max; i++) {
                if (max >= nums.length - 1) {
                    return true;
                }
                max = Math.max(i + nums[i], max);
            }
            return false;
        }

    }


    public static void main(String[] args) {
        JumpGame.ImplNew jumpGame = new JumpGame.ImplNew();
        System.out.println("result false " + jumpGame.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println("result true " + jumpGame.canJump(new int[]{1, 2}));
        System.out.println("result true " + jumpGame.canJump(new int[]{2, 0, 0}));
        System.out.println("result true " + jumpGame.canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));

    }

}
