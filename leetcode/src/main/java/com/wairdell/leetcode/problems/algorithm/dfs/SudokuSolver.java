package com.wairdell.leetcode.problems.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


/**
 * date   : 2024/4/23 9:47
 * desc   : 解数独 https://leetcode.cn/problems/sudoku-solver
 */
public class SudokuSolver {

    public static void main(String[] args) {
        SudokuSolver.Impl2 board = new SudokuSolver.Impl2();
        char[][] sudoku = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        board.solveSudoku(sudoku);

        for (int i = 0; i < sudoku.length; i++) {
            System.out.println(Arrays.toString(sudoku[i]));
        }
    }


    static class Impl2 {

        public void solveSudoku(char[][] board) {
            HashSet<Character>[] unusedVertical = new HashSet[9];
            HashSet<Character>[] unusedHorizontal = new HashSet[9];
            HashSet<Character>[] unusedPartition = new HashSet[9];
            List<int[]> unused = new ArrayList<>();
            for (int i = 0; i < unusedVertical.length; i++) {
                unusedVertical[i] = new HashSet<>();
                unusedHorizontal[i] = new HashSet<>();
                unusedPartition[i] = new HashSet<>();
                for (char j = '1'; j <= '9'; j++) {
                    unusedVertical[i].add(j);
                    unusedHorizontal[i].add(j);
                    unusedPartition[i].add(j);
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    char ch = board[i][j];
                    if (ch != '.') {
                        unusedHorizontal[i].remove(ch);
                        unusedVertical[j].remove(ch);
                        unusedPartition[i / 3 * 3 + j / 3].remove(ch);
                    } else {
                        unused.add(new int[]{i, j});
                    }
                }
            }
            dfs(board, unused, 0, unusedVertical, unusedHorizontal, unusedPartition);
        }

        private HashSet<Character> intersection(HashSet<Character> unusedVertical,
                                                HashSet<Character> unusedHorizontal,
                                                HashSet<Character> unusedPartition) {
            List<HashSet<Character>> allSet = new ArrayList<>(Arrays.asList(unusedVertical, unusedHorizontal, unusedPartition));
            HashSet<Character> minSet = null;
            for (HashSet<Character> set : allSet) {
                if (minSet == null || minSet.size() > set.size()) {
                    minSet = set;
                }
            }
            HashSet<Character> intersectionSet = new HashSet<>();
            allSet.remove(minSet);
            for (Character character : minSet) {
                boolean contains = true;
                for (HashSet<Character> set : allSet) {
                    if (!set.contains(character)) {
                        contains = false;
                        break;
                    }
                }
                if (contains) intersectionSet.add(character);
            }
            return intersectionSet;
        }

        private boolean dfs(char[][] board,
                            List<int[]> unused,
                            int deep,
                            HashSet<Character>[] unusedVerticals,
                            HashSet<Character>[] unusedHorizontals,
                            HashSet<Character>[] unusedPartitions) {
            if (deep == unused.size()) return true;
            int[] pair = unused.get(deep);
            int x = pair[0];
            int y = pair[1];
            int p = x / 3 * 3 + y / 3;
            HashSet<Character> unusedVertical = unusedVerticals[y];
            HashSet<Character> unusedHorizontal = unusedHorizontals[x];
            HashSet<Character> unusedPartition = unusedPartitions[p];
            HashSet<Character> intersection = intersection(unusedVertical, unusedHorizontal, unusedPartition);
            if (intersection.isEmpty()) return false;
            for (Character character : intersection) {
                unusedHorizontal.remove(character);
                unusedVertical.remove(character);
                unusedPartition.remove(character);
                if (dfs(board, unused, deep + 1, unusedVerticals, unusedHorizontals, unusedPartitions)) {
                    board[x][y] = character;
                    return true;
                }
                unusedHorizontal.add(character);
                unusedVertical.add(character);
                unusedPartition.add(character);
            }
            return false;
        }


    }

    static class Impl1 {

        public void solveSudoku(char[][] board) {
            int[][] vertical = new int[9][9];
            int[][] horizontal = new int[9][9];
            int[][] partition = new int[9][9];

            List<int[]> unused = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '.') {
                        unused.add(new int[]{i, j});
                    } else {
                        int num = board[i][j] - '1';
                        horizontal[i][num] = 1;
                        vertical[j][num] = 1;
                        int pi = i / 3 * 3 + j / 3;
                        partition[pi][num] = 1;
                    }
                }
            }
            dfs(board, unused, 0, vertical, horizontal, partition);
        }

        private boolean dfs(char[][] board,
                            List<int[]> unused,
                            int deep,
                            int[][] vertical,
                            int[][] horizontal,
                            int[][] partition) {
            if (deep == unused.size()) return true;
            int[] pair = unused.get(deep);
            int x = pair[0];
            int y = pair[1];
            int p = x / 3 * 3 + y / 3;
            for (char i = '1'; i <= '9'; i++) {
                int num = i - '1';
                if (horizontal[x][num] != 0 || vertical[y][num] != 0 || partition[p][num] != 0)
                    continue;
                horizontal[x][num] = 1;
                vertical[y][num] = 1;
                partition[p][num] = 1;
                if (dfs(board, unused, deep + 1, vertical, horizontal, partition)) {
                    board[x][y] = i;
                    return true;
                }
                horizontal[x][num] = 0;
                vertical[y][num] = 0;
                partition[p][num] = 0;
            }
            return false;
        }

    }


}
