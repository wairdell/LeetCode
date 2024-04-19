package com.wairdell.leetcode.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * author : fengqiao
 * date   : 2023/2/3 11:37
 * desc   : 最大频率栈 https://leetcode.cn/problems/maximum-frequency-stack/
 */
public class MaximumFrequencyStack {

    static class FreqStack {

        private int insertCount = 0;

        private class Node {
            final int num;
            final int count;
            final int insert = insertCount++;

            public Node(int num, int count) {
                this.num = num;
                this.count = count;
            }

        }

        PriorityQueue<Node> queue;
        Map<Integer, Integer> numCount;

        public FreqStack() {
            queue = new PriorityQueue<>(8, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.count != o2.count) return o2.count - o1.count;
                    return o2.insert - o1.insert;
                }
            });
            numCount = new HashMap<>();

        }

        public void push(int val) {
            int count = 0;
            if (numCount.containsKey(val)) {
                count = numCount.get(val) + 1;
            }
            numCount.put(val, count);
            queue.offer(new Node(val, count));
        }

        public int pop() {
            Node poll = queue.poll();
            int num = poll.num;
            numCount.put(num, numCount.get(num) - 1);
            return num;
        }
    }


    public static void main(String[] args) {
        MaximumFrequencyStack.FreqStack freqStack = new MaximumFrequencyStack.FreqStack();
        freqStack.push(1);
        freqStack.push(2);
//        freqStack.push(2);
        freqStack.push(2);
        freqStack.push(3);// 1 2 2 3
        System.out.println(freqStack.pop());//1 2 3 -> 2
        freqStack.push(4);//1 2 3 4
        System.out.println(freqStack.pop());// 1 2 3 -> 4
        freqStack.push(3);//1 2 3 3
        freqStack.push(5);//1 2 3 3 5
        System.out.println(freqStack.pop());// 1 2 3 5 -> 3
        System.out.println(freqStack.pop());//1 2 3 -> 5
        freqStack.push(3);

    }

}
