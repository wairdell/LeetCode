package com.wairdell.leetcode.problems;

import java.util.List;

/**
 * date   : 2024/4/23 9:36
 * desc   : 有效的数独 https://leetcode.cn/problems/valid-sudoku/description/
 */
public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(validSudoku.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] vertical = new int[9][9];
        int[][] horizontal = new int[9][9];
        int[][] partition = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                if (horizontal[i][num]++ > 0) return false;
                if (vertical[j][num]++ > 0) return false;
                int pi = i / 3 * 3 + j / 3;
                if (partition[pi][num]++ > 0) return false;
            }
        }
        return true;
    }



}
