package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;

/**
 * date   : 2024/4/26 13:39
 * desc   : 删除有序数组中的重复项 II https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII duplicates = new RemoveDuplicatesFromSortedArrayII();
        int[] nums = new int[]{1, 1, 2};
        int ret = duplicates.removeDuplicates(nums);
        System.out.println(ret + "," + Arrays.toString(nums));

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        ret = duplicates.removeDuplicates(nums);
        System.out.println(ret + "," + Arrays.toString(nums));

        nums = new int[]{1,1,1,2,2,3};
        ret = duplicates.removeDuplicates(nums);
        System.out.println(ret + "," + Arrays.toString(nums));

        nums = new int[]{0,0,1,1,1,1,2,3,3};
        ret = duplicates.removeDuplicates(nums);
        System.out.println(ret + "," + Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int removeSize = 0;
        for (int i = 2; i < nums.length - removeSize; i++) {
            if (nums[i - 1] == nums[i - 2] && nums[i] == nums[i - 1]) {
                removeSize++;
                for (int j = i; j < nums.length - removeSize; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;
            }
        }
        return nums.length - removeSize;
    }


}
