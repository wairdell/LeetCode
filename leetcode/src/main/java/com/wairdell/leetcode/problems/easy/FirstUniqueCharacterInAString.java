package com.wairdell.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * date   : 2024/5/9 18:19
 * desc   : 字符串中的第一个唯一字符 https://leetcode.cn/problems/first-unique-character-in-a-string
 */
public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        FirstUniqueCharacterInAString inAString = new FirstUniqueCharacterInAString();
        System.out.println(inAString.firstUniqChar("leetcode"));
        System.out.println(inAString.firstUniqChar("loveleetcode"));
        System.out.println(inAString.firstUniqChar("aabb"));
    }

    public int firstUniqChar(String s) {
        int[] visible = new int['z' - 'a' + 1];
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            int status = visible[charAt - 'a'];
            if (status == 0) {
                indexList.add(i);
                visible[charAt - 'a'] = i + 1;
            } else if (status > 0) {
                indexList.remove(Integer.valueOf(status - 1));
                visible[charAt - 'a'] = -1;
            }
        }
        return indexList.isEmpty() ? -1 : indexList.get(0);
    }

}
