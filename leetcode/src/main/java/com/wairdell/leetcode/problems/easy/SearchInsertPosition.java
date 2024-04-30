package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/6 10:42
 * desc   : 搜索插入位置 https://leetcode.cn/problems/search-insert-position
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition position = new SearchInsertPosition();
        System.out.println(position.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(position.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(position.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (target > nums[l]) {
            return l + 1;
        }
        return l;
    }

}
