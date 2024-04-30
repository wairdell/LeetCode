package com.wairdell.leetcode.problems.easy;

import java.util.Random;

/**
 * date   : 2024/4/29 14:35
 * desc   : 找出数组中的第 K 大整数 https://leetcode.cn/problems/find-the-kth-largest-integer-in-the-array
 */
public class FindTheKthLargestIntegerInTheArray {

    public static void main(String[] args) {
        FindTheKthLargestIntegerInTheArray array = new FindTheKthLargestIntegerInTheArray();
        System.out.println(array.kthLargestNumber(new String[]{"3", "6", "7", "10"}, 4));
        System.out.println(array.kthLargestNumber(new String[]{"2", "21", "12", "1"}, 2));
        System.out.println(array.kthLargestNumber(new String[]{"0", "0"}, 1));
        System.out.println(array.kthLargestNumber(new String[]{"623986800", "3", "887298", "695", "794", "6888794705", "269409", "59930972", "723091307", "726368", "8028385786", "378585"}, 11));
    }

    private Random random = new Random();

    private void swap(String[] nums, int i, int j) {
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int compare(String num1, String num2) {
        if (num1.length() != num2.length()) {
            return num1.length() > num2.length() ? 1 : -1;
        }
        return num1.compareTo(num2);
    }

    int[] partition(String[] nums, int l, int r) {
        String pivot = nums[l + random.nextInt(r - l + 1)];
        int i = l;
        while (i <= r) {
            int d = compare(nums[i], pivot);
            if (d < 0) {
                swap(nums, i++, l++);
            } else if (d > 0) {
                swap(nums, i, r--);
            } else {
                i++;
            }
        }
        return new int[]{l, r};
    }

    public String kthLargestNumber(String[] nums, int k) {
        int target = nums.length - k;
        int l = 0, r = nums.length - 1;
        while (true) {
            int[] ret = partition(nums, l, r);
            if (target >= ret[0] && target <= ret[1]) {
                return nums[target];
            } else if (target > ret[1]) {
                l = ret[1] + 1;
            } else {
                r = ret[0] - 1;
            }
        }
    }

}
