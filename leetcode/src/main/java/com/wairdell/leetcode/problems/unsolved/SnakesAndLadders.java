package com.wairdell.leetcode.problems.unsolved;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * date   : 2024/4/27 11:04
 * desc   : 蛇梯棋 https://leetcode.cn/problems/snakes-and-ladders
 */
public class SnakesAndLadders {

    public static void main(String[] args) {
        SnakesAndLadders ladders = new SnakesAndLadders();
//        System.out.println(ladders.posToNo(4, 0, 5));

        System.out.println(Arrays.toString(ladders.noToPos(4, 9)));

        System.out.println("2 = " + ladders.snakesAndLadders(new int[][]{
                {-1, 11, 6, -1},
                {-1, 15, 16, -1},
                {-1, 7, -1, 8},
                {-1, -1, -1, 8}
        }));//2


        System.out.println("3 = " + ladders.snakesAndLadders(new int[][]{
                {-1, 1, 1, 1},
                {-1, 7, 1, 1},
                {16, 1, 1, 1},
                {-1, 1, 9, 1}
        }));//3

        System.out.println("4 = " + ladders.snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        }));//4

        System.out.println("1 = " + ladders.snakesAndLadders(new int[][]{
                {-1, -1},
                {-1, 3}
        }));//1

        System.out.println("2 = " + ladders.snakesAndLadders(new int[][]{
                {-1, 4, -1},
                {6, 2, 6},
                {-1, 3, -1}
        })); //2

        System.out.println("2 = " + ladders.snakesAndLadders(new int[][]{
                {-1, -1, 16, 6, -1},
                {-1, 9, 25, 8, -1},
                {8, 20, 2, 7, -1},
                {-1, -1, 12, -1, -1},
                {-1, -1, -1, 12, 23}
        }));//2


        System.out.println("2 = " + ladders.snakesAndLadders(new int[][]{
                {-1, -1, 16, 6, -1},
                {-1, 9, 25, 8, -1},
                {8, 20, 2, 7, -1},
                {-1, -1, 12, -1, -1},
                {-1, -1, -1, 12, 23}
        }));//2


        System.out.println("2 = " + ladders.snakesAndLadders(new int[][]{
                {-1, -1, 30, 14, 15, -1},
                {23, 9, -1, -1, -1, 9},
                {12, 5, 7, 24, -1, 30},
                {10, -1, -1, -1, 25, 17},
                {32, -1, 28, -1, -1, 32},
                {-1, -1, 23, -1, 13, 19}
        }));//2
//        System.out.println(Arrays.toString(ladders.noToPos(5, 25)));

        System.out.println("4 = " + ladders.snakesAndLadders(new int[][]{
                {-1, -1, -1, 46, 47, -1, -1, -1},
                {51, -1, -1, 63, -1, 31, 21, -1},
                {-1, -1, 26, -1, -1, 38, -1, -1},
                {-1, -1, 11, -1, 14, 23, 56, 57},
                {11, -1, -1, -1, 49, 36, -1, 48},
                {-1, -1, -1, 33, 56, -1, 57, 21},
                {-1, -1, -1, -1, -1, -1, 2, -1},
                {-1, -1, -1, 8, 3, -1, 6, 56}
        }));//4


    }

    int[] noToPos(int n, int no) {
        int i = n - 1 - ((no - 1) / n);
        int j = 0;
        if (((n - 1) - i) % 2 == 0) {
            j = (no - 1) % n;
        } else {
            j = n - 1 - (no - 1) % n;
        }
        return new int[]{i, j};
    }

    int posToNo(int n, int i, int j) {
        int pos = (n - 1 - i) * n;
        if (n % 2 == 0 && (i + 1) % 2 == 0) {
            return pos + j + 1;
        }
        return pos + (n - j);
    }

    class Pair {
        int x;
        int y;
        int no;
        boolean used;

        public Pair(int x, int y, int no, boolean used) {
            this.x = x;
            this.y = y;
            this.no = no;
            this.used = used;
        }
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Set<Pair> set = new HashSet<>();
        int[][] visited = new int[n][n];
        visited[n - 1][0] = 2;
        set.add(new Pair(n - 1, 0, 1, false));
        int d = 1;
        while (!set.isEmpty()) {
            Set<Pair> nextSet = new HashSet<>();
            for (Pair pair : set) {
                for (int i = pair.no + 1; i <= Math.min(pair.no + 6, n * n); i++) {
                    int[] pos = noToPos(n, i);
                    int no = i;
                    if (visited[pos[0]][pos[1]] == 2) continue;
                    if (no == n * n) {
                        return d;
                    }
                    boolean hasJump = board[pos[0]][pos[1]] != -1;
                    if (hasJump && !pair.used) {
                        no = board[pos[0]][pos[1]];
                        pos = noToPos(n, board[pos[0]][pos[1]]);
                        if (no == n * n) {
                            return d;
                        }
                        if (visited[pos[0]][pos[1]] == 0) {
                            visited[pos[0]][pos[1]] = 1;
                            nextSet.add(new Pair(pos[0], pos[1], no, true));
                        }
                    } else {
                        nextSet.add(new Pair(pos[0], pos[1], no, pair.used));
                        if (hasJump) {
                            visited[pos[0]][pos[1]] = 1;
                        }
                    }
                }
            }
            set = nextSet;
            d++;
        }
        return -1;
    }

}
