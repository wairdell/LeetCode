package com.wairdell.leetcode.problems.algorithm.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * date   : 2024/4/23 13:35
 * desc   : 单词接龙 https://leetcode.cn/problems/word-ladder/
 */
public class WordLadder {

    public static void main(String[] args) {
        WordLadder.Impl wordLadder = new WordLadder.Impl();
        System.out.println(wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));

        System.out.println(wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }

    static class Impl {

        public boolean canEvolve(String fromWord, String toWord) {
            if (fromWord.length() != toWord.length()) return false;
            int diff = 0;
            for (int i = 0; i < fromWord.length(); i++) {
                if (fromWord.charAt(i) != toWord.charAt(i) && diff++ > 0) return false;
            }
            return true;
        }

        //双向bfs
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) return 0;
            HashSet<String> usedSet = new HashSet<>();

            HashSet<String> beginSet = new HashSet<>();
            beginSet.add(beginWord);

            HashSet<String> endSet = new HashSet<>();
            endSet.add(endWord);

            int len = 1;

            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                if (beginSet.size() > endSet.size()) {
                    HashSet<String> temp = beginSet;
                    beginSet = endSet;
                    endSet = temp;
                }

                HashSet<String> temp = new HashSet<>();
                for (String word : beginSet) {
                    usedSet.add(word);
                    for (String next : wordSet) {
                        if (!usedSet.contains(next) && canEvolve(word, next)) {
                            if (endSet.contains(next)) return len + 1;
                            temp.add(next);
                        }
                    }
                }
                beginSet = temp;
                len++;
            }
            return 0;
        }

    }


    static class ImplFromMe {

        public boolean canEvolve(String fromWord, String toWord) {
            if (fromWord.length() != toWord.length()) return false;
            int diff = 0;
            for (int i = 0; i < fromWord.length(); i++) {
                if (fromWord.charAt(i) != toWord.charAt(i) && diff++ > 0) return false;
            }
            return true;
        }

        public static class Pair {
            Deque<String> words;
            int step;

            Pair(Deque<String> words, int step) {
                this.words = words;
                this.step = step;
            }
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) return 0;
            HashSet<String> usedSet = new HashSet<>();

            Deque<Pair> beginDeque = new ArrayDeque<>();
            Deque<String> beginWords = new ArrayDeque<>();
            beginWords.offer(beginWord);
            beginDeque.offer(new Pair(beginWords, 0));

            Deque<Pair> endDeque = new ArrayDeque<>();
            Deque<String> endWords = new ArrayDeque<>();
            endWords.offer(endWord);
            endDeque.offer(new Pair(endWords, 0));

            while (!beginDeque.isEmpty() && !endDeque.isEmpty()) {
                if (beginDeque.getFirst().words.size() > endDeque.getFirst().words.size()) {
                    Deque<Pair> temp = beginDeque;
                    beginDeque = endDeque;
                    endDeque = temp;
                }

                Pair pair = beginDeque.poll();
                String word;
                Deque<String> words = new ArrayDeque<>();
                while ((word = pair.words.poll()) != null) {
                    usedSet.add(word);
                    if (endDeque.getFirst().words.contains(word)) {
                        return pair.step + endDeque.getFirst().step + 1;
                    }
                    Iterator<String> iterator = wordSet.iterator();
                    while (iterator.hasNext()) {
                        String next = iterator.next();
                        if (!usedSet.contains(next) && canEvolve(word, next)) {
                            words.add(next);
                        }
                    }
                }
                if (!words.isEmpty()) {
                    beginDeque.offer(new Pair(words, pair.step + 1));
                }
            }
            return 0;
        }

    }


}
