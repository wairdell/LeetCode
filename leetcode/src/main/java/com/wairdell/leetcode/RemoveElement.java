package com.wairdell.leetcode;

import java.util.Arrays;

/**
 * author : fengqiao
 * date   : 2023/2/3 9:59
 * desc   :
 */
public class RemoveElement {

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

    public static void main(String[] args) {
        /*int[] input = new int[]{3, 2, 2, 3};
        int val = 3;*/
//        int[] input = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
//        int val = 2;
        int[] input = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        /*int[] input = new int[]{0, 4, 4, 0, 4, 4, 4, 0, 2};
        int val = 4;*/

        int removeElement = new RemoveElement().removeElement(input, val);
        System.out.println("result = " + removeElement + " , " + Arrays.toString(input));
    }

}
