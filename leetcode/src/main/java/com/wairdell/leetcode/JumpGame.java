package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/6 15:30
 * desc   : 跳跃游戏 https://leetcode.cn/problems/jump-game/
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
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
    }

    public static void main(String[] args) {
        System.out.println("result " + new JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println("result " + new JumpGame().canJump(new int[]{1, 2}));
        System.out.println("result " + new JumpGame().canJump(new int[]{2, 0, 0}));
        System.out.println("result " + new JumpGame().canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));

    }

}
