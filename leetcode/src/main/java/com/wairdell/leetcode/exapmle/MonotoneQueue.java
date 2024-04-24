package com.wairdell.leetcode.exapmle;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * date   : 2024/4/24 16:21
 * desc   : 单调队列
 */
public class MonotoneQueue {

    static class DequeImpl {

        Deque<Integer> deque = new ArrayDeque<>();

        public void push(int value) {
            while (!deque.isEmpty() && deque.getLast() < value) {
                deque.pollLast();
            }
            deque.addLast(value);
        }

        public void pop(int value) {
            if (deque.getFirst() == value) {
                deque.pollFirst();
            }
        }

        public int getTop() {
            return deque.getFirst();
        }

    }

    static class ArrayImpl {

        private static final int INF = 0;
        int n;
        int[] queue;
        int count;
        int start;

        ArrayImpl(int n) {
            this.n = n;
            queue = new int[n];
        }

        private int first() {
            return queue[start];
        }

        private int lastIndex() {
            return (start + count - 1) % n;
        }

        private int last() {
            return queue[lastIndex()];
        }

        private boolean isEmpty() {
            return count == 0;
        }

        private void removeLast() {
            queue[lastIndex()] = INF;
            count--;
        }

        private void addLast(int value) {
            count++;
            queue[lastIndex()] = value;
        }

        public void push(int value) {
            while (!isEmpty() && last() < value) {
                removeLast();
            }
            addLast(value);
        }

        private void removeFirst() {
            queue[start] = INF;
            count--;
            start = (start + 1) % n;
        }

        public void pop(int value) {
            if (first() == value) {
                removeFirst();
            }
        }

    }


}
