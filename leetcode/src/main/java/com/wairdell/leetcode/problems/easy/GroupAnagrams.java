package com.wairdell.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author : fengqiao
 * date   : 2023/2/6 16:01
 * desc   : 字母异位词分组 https://leetcode.cn/problems/group-anagrams/
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int['z' - 'a' + 1];
            byte[] bytes = str.getBytes();
            for (byte aByte : bytes) {
                int i = aByte - 'a';
                count[i] = count[i] + 1;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    keyBuilder.append(i + 'a').append(count[i]);
                }
            }
            String key = keyBuilder.toString();
            if (map.containsKey(key)) {
                List<String> stringList = map.get(key);
                stringList.add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println("result = " + new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

}
