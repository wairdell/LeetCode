package com.wairdell.leetcode.problems.structure.trie;

/**
 * date   : 2024/4/19 9:35
 * desc   : 实现 Trie (前缀树) https://leetcode.cn/problems/implement-trie-prefix-tree
 */
public class ImplementTriePrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean ret = trie.search("apple");
        System.out.println(ret);
    }


    private static class Trie {

        public static final int N = 26;

        private Trie[] nodes = new Trie[N];

        private boolean isEnd = false;

        public Trie() {

        }

        private Trie getChild(char ch) {
            return nodes[ch - 'a'];
        }

        private void addChild(char ch, Trie child) {
            nodes[ch -'a'] = child;
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


}
