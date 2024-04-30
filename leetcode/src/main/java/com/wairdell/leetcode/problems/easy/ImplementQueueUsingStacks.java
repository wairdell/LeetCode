package com.wairdell.leetcode.problems.easy;

import java.util.Stack;

/**
 * date   : 2024/4/30 10:56
 * desc   : 用栈实现队列 https://leetcode.cn/problems/implement-queue-using-stacks
 */
public class ImplementQueueUsingStacks {

    public static void main(String[] args) {

    }

    class MyQueue {

        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public MyQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        public void push(int x) {
            pushStack.push(x);
        }

        public int pop() {
            if (!popStack.isEmpty()) {
                return popStack.pop();
            }
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
            return popStack.pop();
        }

        public int peek() {
            if (!popStack.isEmpty()) {
                return popStack.peek();
            }
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
            return popStack.peek();
        }

        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }
    }

}
