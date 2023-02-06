package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/2/3 11:37
 * desc   : 最大频率栈 https://leetcode.cn/problems/maximum-frequency-stack/
 */
public class MaximumFrequencyStack {

    private ItemInfo head;

    private class ItemInfo {
        private int item;
        private int count;
        private ItemInfo next;
        private ItemInfo previous;

        public ItemInfo(ItemInfo previous, int item) {
            this.previous = previous;
            this.item = item;
            this.count = 1;
        }

        public void setNext(ItemInfo next) {
            this.next = next;
            if (next != null) {
                next.previous = this;
            }
        }
    }

    public MaximumFrequencyStack() {
    }

    public void push(int val) {
        pushCountStack(val);
    }

    public void pushCountStack(int val) {
        ItemInfo next = head;
        ItemInfo previous = head;
        if (next != null) {
            do {
                if (next.item == val) {
                    ++next.count;
                    previous = next;
                    while ((previous = previous.previous) != null && previous.count < next.count) {
                    }
                    if (previous != next.previous) {
                        next.previous.setNext(next.next);
                        if (previous != null) {
                            next.setNext(previous.next);
                            previous.setNext(next);
                        } else {
                            next.setNext(head);
                            next.previous = null;
                            head = next;
                        }
                    }
                    return;
                }
                previous = next;
            } while ((next = next.next) != null);
            previous.next = new ItemInfo(previous, val);
        } else {
            head = new ItemInfo(null, val);
        }
    }

    public void popCountStack() {
        ItemInfo target = head;
        head.count--;
        if (head.count == 0) {
            head = target.next;
            if (head != null) {
                head.previous = null;
            }
            return;
        }
        if (target.next != null) {
            ItemInfo next = target;
            while (next.next != null && next.next.count > target.count) {
                next = next.next;
            }
            target.next.previous = null;
            head = target.next;

            target.setNext(next.next);
            next.setNext(target);
        }
    }

    public int pop() {
        if (head != null) {
            ItemInfo top = head;
            head = top.next;
            return top.item;
        }
        return 0;
    }

    private void printStack() {
        ItemInfo next = head;
        while (next != null) {
            System.out.println(next.item + "," + next.count);
            next = next.next;
        }
    }

    public static void main(String[] args) {
        MaximumFrequencyStack freqStack = new MaximumFrequencyStack();
        freqStack.push(1);
        freqStack.push(2);
//        freqStack.push(2);
        freqStack.push(2);
        freqStack.push(3);
        freqStack.pop();
        freqStack.push(4);
        freqStack.push(3);
        freqStack.push(1);
        freqStack.push(3);

    }

}
