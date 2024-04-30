package com.wairdell.leetcode.problems.easy;

import java.util.Objects;

/**
 * date   : 2024/5/1 20:45
 * desc   : 到目标字符串的最短距离 https://leetcode.cn/problems/shortest-distance-to-target-string-in-a-circular-array
 */
public class ShortestDistanceToTargetStringInACircularArray {

    public static void main(String[] args) {
        ShortestDistanceToTargetStringInACircularArray distance = new ShortestDistanceToTargetStringInACircularArray();
//        System.out.println(distance.closetTarget(new String[]{"hello","i","am","leetcode","hello"}, "hello", 1));
//        System.out.println(distance.closetTarget(new String[]{"i", "eat", "leetcode"}, "ate", 0));
        System.out.println(distance.closetTarget(new String[]{"hsdqinnoha", "mqhskgeqzr", "zemkwvqrww", "zemkwvqrww", "daljcrktje", "fghofclnwp", "djwdworyka", "cxfpybanhd", "fghofclnwp", "fghofclnwp"}, "zemkwvqrww", 8));
    }

    public int closetTarget(String[] words, String target, int startIndex) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (Objects.equals(target, words[i])) {
                ans = Math.min(ans, Math.abs(i - startIndex));
                if (i > startIndex) {
                    ans = Math.min(ans, words.length - i + startIndex);
                } else {
                    ans = Math.min(ans, words.length - startIndex + i);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
