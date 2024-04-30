package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/28 17:12
 * desc   : 简化路径 https://leetcode.cn/problems/simplify-path
 */
public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath path = new SimplifyPath();
        System.out.println(path.simplifyPath("/home/")); // /home
        System.out.println(path.simplifyPath("/../"));// /
        System.out.println(path.simplifyPath("/home//foo/"));///home/foo
        System.out.println(path.simplifyPath("/a/./b/../../c/"));//c
        System.out.println(path.simplifyPath("/a//b////c/d//././/..")); // /a/b/c
        System.out.println(path.simplifyPath("/...")); // /a/b/c
    }

    private static class Dir {
        private String name;

        private Dir parent;
    }

    public String simplifyPath(String path) {
        Dir next = new Dir();
        String word = "";
        for (int i = 1; i < path.length(); i++) {
            char charAt = path.charAt(i);
            if (charAt == '/') {
                if (word.length() > 0) {
                    if ("..".equals(word)) {
                        next = next.parent != null ? next.parent : new Dir();
                        next.name = null;
                    } else if (!".".equals(word)){
                        next.name = word.toString();
                        Dir node = new Dir();
                        node.parent = next;
                        next = node;
                    }
                    word = "";
                }
            } else {
                word += charAt;
                if (i == path.length() - 1) {
                    if ("..".equals(word)) {
                        next = next.parent != null ? next.parent : new Dir();
                        next.name = null;
                    } else if (!".".equals(word)) {
                        next.name = word;
                    }
                }
            }
        }
        if (next.name == null && next.parent == null) {
            return "/";
        }
        if (next.name == null) {
            next = next.parent;
        }
        String ans = "";
        while (next != null) {
            ans = "/" + next.name + ans;
            next = next.parent;
        }
        return ans;
    }

}
