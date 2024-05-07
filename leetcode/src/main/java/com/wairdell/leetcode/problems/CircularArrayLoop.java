package com.wairdell.leetcode.problems;

/**
 * date   : 2024/5/7 17:42
 * desc   : 环形数组是否存在循环 https://leetcode.cn/problems/circular-array-loop
 */
public class CircularArrayLoop {

    public static void main(String[] args) {
        CircularArrayLoop loop = new CircularArrayLoop();
        System.out.println(loop.circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
        System.out.println(loop.circularArrayLoop(new int[]{-1, 2}));
        System.out.println(loop.circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));
        System.out.println(loop.circularArrayLoop(new int[]{-1, -2, -3, -4, -5}));
    }

    public boolean circularArrayLoop(int[] nums) {
        int[] visited = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (dfs(nums, i, visited, 0, nums[i] > 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int[] nums, int i, int[] visited, int k, boolean isPositive) {
        if (visited[i] == 1) {
            return true;
        }
        if (visited[i] == 2) return false;
        if (isPositive != (nums[i] > 0)) return false;
        visited[i] = 1;
        int n = nums.length;
        int next = (i + nums[i]) % n;
        next = next < 0 ? next + n : next;
        if (next == i) {
            visited[i] = 2;
            return false;
        }
        if (dfs(nums, next, visited, k + 1, isPositive)) {
            return true;
        }
        visited[i] = 2;
        return false;
    }

}
