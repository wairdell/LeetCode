package com.wairdell.leetcode.problems.help.practised;

/**
 * author : fengqiao
 * date   : 2023/2/8 13:34
 * desc   : 多数元素 https://leetcode.cn/problems/majority-element/
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        //因为多数元素出现次数大于 n/2，所以不管哪时候出现，target 总能标记为多数元素
        Integer target = null;
        for (int num : nums) {
            if (count == 0) {
                target = num;
            }
            count += (target == num ? 1 : -1);
        }
        return target;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

}
