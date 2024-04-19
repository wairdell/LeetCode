package com.wairdell.leetcode.problems.algorithm.dfs;

/**
 * date   : 2024/4/19 10:34
 * desc   : 单词搜索 https://leetcode.cn/problems/word-search
 */
public class WordSearch {

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        boolean ret = false;
        ret = wordSearch.exist(new char[][]{new char[]{'A', 'B', 'C', 'E'},
                        new char[]{'S', 'F', 'C', 'S'},
                        new char[]{'A', 'D', 'E', 'E'}},
                "ABCCED");

        System.out.println(ret);

        ret = wordSearch.exist(new char[][]{new char[]{'A', 'B', 'C', 'E'},
                        new char[]{'S', 'F', 'C', 'S'},
                        new char[]{'A', 'D', 'E', 'E'}},
                "SEE");

        System.out.println(ret);
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] dx = new int[]{0, 0, 1, -1};
    private int[] dy = new int[]{1, -1, 0, 0};

    public boolean dfs(char[][] board, String word, int x, int y, int k) {
        if (x < 0 || x >= board.length) return false;
        if (y < 0 || y >= board[x].length) return false;
        char ch = board[x][y];
        if (ch == word.charAt(k)) {
            if (k == word.length() - 1) return true;
            board[x][y] = '@';
            for (int i = 0; i < dx.length; i++) {
                if (dfs(board, word, x + dx[i], y + dy[i], k + 1)) {
                    return true;
                }
            }
            board[x][y] = ch;
        }
        return false;
    }

}
