package com.wairdell.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * date   : 2024/4/29 17:11
 * desc   : 找出数组排序后的目标下标 https://leetcode.cn/problems/find-target-indices-after-sorting-array
 */
public class FindTargetIndicesAfterSortingArray {

    public static void main(String[] args) {
        FindTargetIndicesAfterSortingArray array = new FindTargetIndicesAfterSortingArray();
        System.out.println(array.targetIndices(new int[]{1, 2, 5, 2, 3}, 2));
        System.out.println(array.targetIndices(new int[]{1, 2, 5, 2, 3}, 3));
        System.out.println(array.targetIndices(new int[]{1, 2, 5, 2, 3}, 5));
        System.out.println(array.targetIndices(new int[]{1, 2, 5, 2, 3}, 4));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int[] partition(int[] nums, int pivot, int l, int r) {
        int less = l, i = l, greater = r;
        while (i <= greater) {
            if (nums[i] < pivot) {
                swap(nums, i++, less++);
            } else if (nums[i] > pivot) {
                swap(nums, i, greater--);
            } else {
                i++;
            }
        }
        return new int[]{less, greater};
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        int[] ret = partition(nums, target, 0, nums.length - 1);
        List<Integer> ans = new ArrayList<>();
        for (int i = ret[0]; i <= ret[1]; i++) {
            ans.add(i);
        }
        return ans;
    }

}
