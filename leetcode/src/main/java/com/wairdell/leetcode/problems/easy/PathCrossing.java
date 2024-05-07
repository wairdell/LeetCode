package com.wairdell.leetcode.problems.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * date   : 2024/5/7 9:40
 * desc   : 判断路径是否相交 https://leetcode.cn/problems/path-crossing
 */
public class PathCrossing {

    public static void main(String[] args) {
        PathCrossing crossing = new PathCrossing();
        System.out.println(crossing.isPathCrossing("NES"));
        System.out.println(crossing.isPathCrossing("NESWW"));
    }

    public boolean isPathCrossing(String path) {
        Set<String> posSet = new HashSet<>();
        posSet.add("0,0");
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char charAt = path.charAt(i);
            switch (charAt) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            if (posSet.contains(x + "," + y)) return true;
            posSet.add(x + "," + y);
        }
        return false;
    }

}
