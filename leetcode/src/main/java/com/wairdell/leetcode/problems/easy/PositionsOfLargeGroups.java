package com.wairdell.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * date   : 2024/4/30 11:40
 * desc   : 较大分组的位置 https://leetcode.cn/problems/positions-of-large-groups
 */
public class PositionsOfLargeGroups {

    public static void main(String[] args) {
        PositionsOfLargeGroups groups = new PositionsOfLargeGroups();
        System.out.println(groups.largeGroupPositions("abcdddeeeeaabbbcd"));
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        char pre = s.charAt(0);
        int j = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length() || pre != s.charAt(i)) {
                if (i - j >= 3) {
                    ans.add(Arrays.asList(j, i - 1));
                }
                if (i == s.length()) continue;
                pre = s.charAt(i);
                j = i;
            }
        }
        return ans;
    }

}
