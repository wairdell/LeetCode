package com.wairdell.leetcode.problems.structure.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * date   : 2024/4/19 9:49
 * desc   : 单词搜索 II https://leetcode.cn/problems/word-search-ii
 */
public class WordSearchII {

    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
        List<String> result = null;
        result = wordSearchII.findWords(new char[][]{new char[]{'o', 'a', 'a', 'n'},
                new char[]{'e', 't', 'a', 'e'},
                new char[]{'i', 'h', 'k', 'r'}},
                new String[]{"oath", "pea", "eat", "rain"});
        System.out.println(result);

        result = wordSearchII.findWords(new char[][]{new char[]{'o', 'a', 'b', 'n'},
                        new char[]{'o', 't', 'a', 'e'},
                        new char[]{'a', 'h', 'k', 'r'},
                        new char[]{'a', 'f', 'l', 'v'}
                },
                new String[]{"oa", "oaa"});
        System.out.println(result);
    }

    static class Trie {

        public static final int N = 26;

        private Trie[] nodes = new Trie[N];

        private boolean isEnd = false;

        public Trie() {

        }

        private Trie getChild(char ch) {
            return nodes[ch - 'a'];
        }

        private void addChild(char ch, Trie child) {
            nodes[ch - 'a'] = child;
        }

        private Trie getOrCreateChild(char ch) {
            Trie child = getChild(ch);
            if (child == null) {
                child = new Trie();
                addChild(ch, child);
            }
            return child;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char charAt = word.charAt(i);
                node = node.getOrCreateChild(charAt);
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char charAt = word.charAt(i);
                node = node.getChild(charAt);
                if (node == null) return false;
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char charAt = prefix.charAt(i);
                node = node.getChild(charAt);
                if (node == null) return false;
            }
            return true;
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> ans = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ans.addAll(dfs(trie, board, i, j, ""));
            }
        }
        return new ArrayList<>(ans);
    }

    private int dx[] = new int[]{0, 0, 1, -1};
    private int dy[] = new int[]{1, -1, 0, 0};

    public List<String> dfs(Trie trie, char[][] board, int x, int y, String prefix) {
        if (x < 0 || x >= board.length) return Collections.emptyList();
        if (y < 0 || y >= board[x].length) return Collections.emptyList();
        char ch = board[x][y];
        if (ch == '@') return Collections.emptyList();

        List<String> result = new ArrayList<>();
        Trie child = trie.getChild(ch);
        if (child == null) return Collections.emptyList();

        String now = prefix + ch;
        if (child.isEnd) {
            result.add(now);
        }
        board[x][y] = '@';
        for (int i = 0; i < dx.length; i++) {
            result.addAll(dfs(child, board, x + dx[i], y + dy[i], now));
        }
        board[x][y] = ch;
        return result;
    }

}
