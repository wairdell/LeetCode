package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/8 13:34
 * desc   :
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += (nums[i] == candidate ? 1 : -1);
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

}
