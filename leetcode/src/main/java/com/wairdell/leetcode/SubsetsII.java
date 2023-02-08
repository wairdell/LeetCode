package com.wairdell.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/8 9:58
 * desc   :
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SubsetsII().subsetsWithDup(new int[]{1, 2, 2}));
    }

}
