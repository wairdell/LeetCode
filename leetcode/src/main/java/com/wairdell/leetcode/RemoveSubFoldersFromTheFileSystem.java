package com.wairdell.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author : fengqiao
 * date   : 2023/2/8 14:46
 * desc   : 删除子文件夹 https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/
 */
public class RemoveSubFoldersFromTheFileSystem {

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        String preview = folder[0];
        result.add(preview);
        for (int i = 1; i < folder.length; i++) {
            if (!folder[i].startsWith(preview + "/")) {
                result.add(folder[i]);
                preview = folder[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveSubFoldersFromTheFileSystem().removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}));
        System.out.println(new RemoveSubFoldersFromTheFileSystem().removeSubfolders(new String[]{"/a","/a/b/c","/a/b/d"}));
        System.out.println(new RemoveSubFoldersFromTheFileSystem().removeSubfolders(new String[]{"/a/b/c","/a/b/ca","/a/b/d"}));
    }

}
