package com.wairdell.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date   : 2024/4/29 17:32
 * desc   :
 */
public class KthDistinctStringInAnArray {

    public static void main(String[] args) {
        KthDistinctStringInAnArray kth = new KthDistinctStringInAnArray();
        System.out.println(kth.kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2));
        System.out.println(kth.kthDistinct(new String[]{"aaa", "aa", "a"}, 1));
        System.out.println(kth.kthDistinct(new String[]{"a", "b", "a"}, 3));
    }

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> find = new HashMap<>();
        List<String> unique = new ArrayList<>();
        for (String s : arr) {
            if (find.getOrDefault(s, 0) == 0) {
                unique.add(s);
                find.put(s, 1);
            } else {
                int count = find.get(s);
                if (count == 1) {
                    unique.remove(s);
                }
                find.put(s, count + 1);
            }
        }
        if (unique.size() >= k) {
            return unique.get(k - 1);
        }
        return "";
    }

}
