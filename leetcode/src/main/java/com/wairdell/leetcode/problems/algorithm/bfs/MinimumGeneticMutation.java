package com.wairdell.leetcode.problems.algorithm.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * date   : 2024/4/23 14:39
 * desc   : 最小基因变化 https://leetcode.cn/problems/minimum-genetic-mutation/
 */
public class MinimumGeneticMutation {

    public static void main(String[] args) {
        MinimumGeneticMutation mutation = new MinimumGeneticMutation();
        System.out.println(mutation.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(mutation.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(mutation.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));

    }

    boolean canEvolve(String fromGene, String toGene) {
        int count = 0;
        for (int i = 0; i < fromGene.length(); i++) {
            if (fromGene.charAt(i) != toGene.charAt(i) && count++ > 0) return false;
        }
        return true;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(startGene);
        Set<String> endSet = new HashSet<>();
        endSet.add(endGene);
        HashSet<String> visitedSet = new HashSet<>();
        int len = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> swapTemp = beginSet;
                beginSet = endSet;
                endSet = swapTemp;
            }
            Set<String> nextSet = new HashSet<>();
            for (String gene : beginSet) {
                visitedSet.add(gene);
                for (String nextGene : bankSet) {
                    if (!visitedSet.contains(nextGene) && canEvolve(gene, nextGene)) {
                        if (endSet.contains(nextGene)) return len + 1;
                        nextSet.add(nextGene);
                    }
                }
            }
            beginSet = nextSet;
            len++;
        }
        return -1;
    }

}
