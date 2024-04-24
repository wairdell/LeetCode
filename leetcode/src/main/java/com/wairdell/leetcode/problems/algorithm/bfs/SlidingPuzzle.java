package com.wairdell.leetcode.problems.algorithm.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * date   : 2024/4/24 17:37
 * desc   : 滑动谜题 https://leetcode.cn/problems/sliding-puzzle
 */
public class SlidingPuzzle {

    public static void main(String[] args) {
        SlidingPuzzle puzzle = new SlidingPuzzle();
        System.out.println(puzzle.slidingPuzzle(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 0, 5}
        }));//1

        System.out.println(puzzle.slidingPuzzle(new int[][]{
                new int[]{1, 2, 3},
                new int[]{5, 4, 0}
        }));//1

        System.out.println(puzzle.slidingPuzzle(new int[][]{
                new int[]{4, 1, 2},
                new int[]{5, 0, 3}
        }));//5
    }

    static final int[][] OPERATES = new int[6][];
    static final String END_BOARD = "123450";

    static {
        //0 1 2
        //3 4 5
        OPERATES[0] = new int[]{1, 3};
        OPERATES[1] = new int[]{0, 2, 4};
        OPERATES[2] = new int[]{1, 5};
        OPERATES[3] = new int[]{0, 4};
        OPERATES[4] = new int[]{1, 3, 5};
        OPERATES[5] = new int[]{2, 4};
    }

    public String newBoard(String board, int fromIndex, int toIndex) {
        char[] charArray = board.toCharArray();
        char temp = charArray[fromIndex];
        charArray[fromIndex] = charArray[toIndex];
        charArray[toIndex] = temp;
        return String.valueOf(charArray);
    }

    public int slidingPuzzle(int[][] board) {
        StringBuilder beginBuilder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                beginBuilder.append(board[i][j]);
            }
        }
        String begin = beginBuilder.toString();
        if (END_BOARD.equals(begin)) {
            return 0;
        }
        Set<String> boardSet = new HashSet<>();
        boardSet.add(begin);
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(begin, true);
        int cnt = 0;
        while (!boardSet.isEmpty()) {
            Set<String> nextSet = new HashSet<>();
            for (String s : boardSet) {
                int zeroIndex = s.indexOf('0');
                int[] operate = OPERATES[zeroIndex];
                for (int p : operate) {
                    String nextBoard = newBoard(s, zeroIndex, p);
                    if (END_BOARD.equals(nextBoard)) return cnt + 1;
                    if (!visited.containsKey(nextBoard)) {
                        nextSet.add(nextBoard);
                        visited.put(nextBoard, true);
                    }
                }
            }
            boardSet = nextSet;
            cnt++;
        }
        return -1;
    }

}
