package com.wairdell.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * author : fengqiao
 * date   : 2023/2/13 15:35
 * desc   : 模拟行走机器人 https://leetcode.cn/problems/walking-robot-simulation/
 */
public class WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {
        /*y = 1; x = 0;
        y = 0; x = 1;
        y = -1; x = 0;
        y = 0; x = -1;*/
        int x = 0;
        int y = 0;
        int ans = 0;
        int[][] offsetArray = new int[][]{new int[]{1, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{0, -1}};
        int direction = 0;
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            if (command == -1) {
                direction = (direction + 1) % offsetArray.length;
            } else if (command == -2) {
                direction = direction == 0 ? 3 : (direction - 1) % offsetArray.length;
            } else {
                int[] offset = offsetArray[direction];
                for (int j = 0; j < command; j++) {
                    String key = (x + offset[1]) + "," + (y + offset[0]);
                    if (!obstacleSet.contains(key)) {
                        x += offset[1];
                        y += offset[0];
                        ans = Math.max(x * x + y * y, ans);
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println("result = " + new WalkingRobotSimulation().robotSim(new int[]{4, -1, 3}, new int[][]{}));
        System.out.println("result = " + new WalkingRobotSimulation().robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{new int[]{2, 4}}));
        System.out.println("result = " + new WalkingRobotSimulation().robotSim(new int[]{6, -1, -1, 6}, new int[][]{}));
        System.out.println("result = " + new WalkingRobotSimulation().robotSim(new int[]{-2, 8, 3, 7, -1}, new int[][]{new int[]{-4, -1}, new int[]{1, -1}, new int[]{1, 4}, new int[]{5, 0}, new int[]{4, 5}, new int[]{-2, -1}, new int[]{2, -5}, new int[]{5, 1}, new int[]{-3, -1}, new int[]{5, -3}}));

    }

}
