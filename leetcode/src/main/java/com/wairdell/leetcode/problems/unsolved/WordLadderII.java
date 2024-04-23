package com.wairdell.leetcode.problems.unsolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * date   : 2024/4/23 15:25
 * desc   :
 */
public class WordLadderII {

    public static void main(String[] args) {
        WordLadderII ladderII = new WordLadderII();
        System.out.println(ladderII.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));

//        System.out.println(ladderII.findLadders("red", "tax", Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee")));
    }

    static class Pair {

        String word;
        Pair previous;
        Pair next;
        Set<String> visited;

        public Pair(String word, Pair previous, Pair next, Set<String> visited) {
            this.word = word;
            this.previous = previous;
            this.next = next;
            this.visited = visited;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return Collections.emptyList();

        Set<String> wordSet = new HashSet<>(wordList);

        Set<Pair> beginSet = new HashSet<>();
        beginSet.add(new Pair(beginWord, null, null, new HashSet<String>(Arrays.asList(beginWord))));

        Set<Pair> endSet = new HashSet<>();
        endSet.add(new Pair(endWord, null, null, new HashSet<String>(Arrays.asList(endWord))));

        /*Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);*/

        boolean isMeet = false;
        boolean isBegin = true;
        List<List<String>> ans = new ArrayList<>();
        HashSet<String> endSetWord = new HashSet<>();
        endSetWord.add(endWord);

//        List<String> meetList = new ArrayList<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<Pair> swapTemp = beginSet;
                beginSet = endSet;
                endSet = swapTemp;
                isBegin = !isBegin;

                endSetWord.clear();
                for (Pair pair : endSet) {
                    endSetWord.add(pair.word);
                }

            }
            Set<Pair> nextSet = new HashSet<>();
            for (Pair pair : beginSet) {
                String word = pair.word;
                char[] chars = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char oldChatAt = word.charAt(i);
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == oldChatAt) continue;
                        chars[i] = j;
                        String target = String.valueOf(chars);
                        if (endSetWord.contains(target)) {
                            isMeet = true;
                            Pair endPair = null;
                            for (Pair p : endSet) {
                                if (target.equals(p.word)) {
                                    endPair = p;
                                    break;
                                }
                            }
                            List<String> mutation = new ArrayList<>();
                            Pair l = isBegin ? pair : endPair;
                            Pair r = isBegin ? endPair : pair;
                            while (l != null) {
                                mutation.add(0, l.word);
                                l = l.previous;
                            }
                            while (r != null) {
                                mutation.add(r.word);
                                r = r.next;
                            }
                            ans.add(mutation);
                        }
                        if (isMeet) continue;
                        if (wordSet.contains(target) && !pair.visited.contains(target)) {
                            pair.visited.add(target);
                            nextSet.add(new Pair(target, isBegin ? pair : null, isBegin ? null : pair, new HashSet<String>(pair.visited)));
                        }
                    }
                    chars[i] = oldChatAt;
                }
            }
            if (isMeet) {
                break;
            }
            beginSet = nextSet;
        }

        return ans;
    }

}
