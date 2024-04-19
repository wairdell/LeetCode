package com.wairdell.leetcode.problems.easy;

import java.util.Arrays;

/**
 * author : fengqiao
 * date   : 2023/2/3 9:59
 * desc   : 移除元素 https://leetcode.cn/problems/remove-element/description/
 */
public class RemoveElement {

    static class Impl {

        public int removeElement(int[] nums, int val) {
            int length = nums.length;
            int cacheRemove = 0;
            int i;
            for (i = 0; i < length; i++) {
                if (nums[i] == val) {
                    cacheRemove++;
                } else {
                    if (cacheRemove > 0) {
                        remove(nums, i, cacheRemove, length);
                        length -= cacheRemove;
                        i -= cacheRemove;
                        cacheRemove = 0;
                    }
                }
            }
            if (cacheRemove > 0) {
                remove(nums, i, cacheRemove, length);
                length -= cacheRemove;
            }
            return length;
        }

        private void remove(int[] nums, int i, int cacheRemove, int length) {
            for (int j = i - cacheRemove; j < length; j++) {
                if (j >= length - cacheRemove) {
                    nums[j] = 0;
                } else {
                    nums[j] = nums[j + cacheRemove];
                }
            }
        }
    }

    static class ImplNew {

        public int removeElement(int[] nums, int val) {
            int n = nums.length;
            int i = 0;
            while (i < n) {
                if (nums[i] == val) {
                    for (int j = i; j < n - 1; j++) {
                        nums[j] = nums[j + 1];
                    }
                    nums[n - 1] = 0;
                    n--;
                } else {
                    i++;
                }
            }
            return n;
        }
    }





    public static void main(String[] args) {
        ImplNew impl = new ImplNew();

        int[] input = new int[]{3, 2, 2, 3};
        int val = 3;
        int removeElement = impl.removeElement(input, val);
        System.out.println("result = " + removeElement + " , " + Arrays.toString(input));

        input = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;
        removeElement = impl.removeElement(input, val);
        System.out.println("result = " + removeElement + " , " + Arrays.toString(input));

        input = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;
        removeElement = impl.removeElement(input, val);
        System.out.println("result = " + removeElement + " , " + Arrays.toString(input));

        input = new int[]{0, 4, 4, 0, 4, 4, 4, 0, 2};
        val = 4;
        removeElement = impl.removeElement(input, val);
        System.out.println("result = " + removeElement + " , " + Arrays.toString(input));
    }

}
