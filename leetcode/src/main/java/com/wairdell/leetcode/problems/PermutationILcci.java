package com.wairdell.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * date   : 2024/4/22 17:37
 * desc   :
 */
public class PermutationILcci {

    public static void main(String[] args) {
        PermutationILcci lcci = new PermutationILcci();
        System.out.println(Arrays.toString(lcci.permutation("qwe")));
    }

    public String[] permutation(String s) {
        char[] charArray = s.toCharArray();
        List<String> result = dfs(charArray, "", new boolean[charArray.length]);
        String[] ans = new String[result.size()];
        result.toArray(ans);
        return ans;
    }

    private List<String> dfs(char[] charArray, String prefix, boolean[] used) {
        if (prefix.length() == charArray.length) return Collections.singletonList(prefix);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (!used[i]) {
                used[i] = true;
                ans.addAll(dfs(charArray, prefix + charArray[i], used));
                used[i] = false;
            }
        }
        return ans;
    }

}
