package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/6 10:22
 * desc   : 输入单词需要的最少按键次数 II https://leetcode.cn/problems/minimum-number-of-pushes-to-type-word-ii
 */
public class MinimumNumberOfPushesToTypeWordII {

    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWordII ii = new MinimumNumberOfPushesToTypeWordII();
        System.out.println(ii.minimumPushes("abcde"));
        System.out.println(ii.minimumPushes("xyzxyzxyzxyz"));
        System.out.println(ii.minimumPushes("aabbccddeeffgghhiiiiii"));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int[] partition(int[] nums, int l, int r) {
        int less = l, i = less, greater = r;
        int pivot = nums[l];
        while (i <= greater) {
            if (nums[i] > pivot) {
                swap(nums, i++, less++);
            } else if (nums[i] < pivot) {
                swap(nums, i, greater--);
            } else {
                i++;
            }
        }
        return new int[]{less, greater};
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int[] ret = partition(nums, l, r);
        quickSort(nums, l, ret[0] - 1);
        quickSort(nums, ret[1] + 1, r);
    }

    public int minimumPushes(String word) {
        int size = 'z' - 'a' + 1;
        int[] cnt = new int[size];
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            cnt[index]++;
        }
        quickSort(cnt, 0, cnt.length - 1);
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (cnt[i] == 0) return sum;
            sum += cnt[i] * Math.ceil((i + 1) / 8d);
        }
        return sum;
    }

}
