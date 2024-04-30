package com.wairdell.leetcode.problems.algorithm.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * date   : 2024/4/30 14:46
 * desc   : 钥匙和房间 https://leetcode.cn/problems/keys-and-rooms
 */
public class KeysAndRooms {

    public static void main(String[] args) {
        KeysAndRooms rooms = new KeysAndRooms();
        System.out.println(rooms.canVisitAllRooms(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList())));
        System.out.println(rooms.canVisitAllRooms(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2), Arrays.asList(0))));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        while (!set.isEmpty()) {
            Set<Integer> nextSet = new HashSet<>();
            for (Integer room : set) {
                for (Integer nextRoom : rooms.get(room)) {
                    if (!visited[nextRoom]) {
                        nextSet.add(nextRoom);
                    }
                    visited[nextRoom] = true;
                }
            }
            set = nextSet;
        }

        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }

}
