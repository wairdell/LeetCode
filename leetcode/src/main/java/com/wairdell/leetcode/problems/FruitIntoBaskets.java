package com.wairdell.leetcode.problems;

/**
 * date   : 2024/4/25 14:15
 * desc   : 水果成篮 https://leetcode.cn/problems/fruit-into-baskets
 */
public class FruitIntoBaskets {

    public static void main(String[] args) {
        QueueImpl fruit = new QueueImpl();
        System.out.println(fruit.totalFruit(new int[]{1, 2, 1})); //3
        System.out.println(fruit.totalFruit(new int[]{0, 1, 2, 2}));//3
        System.out.println(fruit.totalFruit(new int[]{1, 2, 3, 2, 2}));//4
        System.out.println(fruit.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));//5
        System.out.println(fruit.totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3}));//5
    }

    static class QueueImpl {

        static class CustomLink {

            static class Node {
                int val;
                Node next;
                Node pre;

                public Node() {

                }

                public Node(int val, Node next, Node pre) {
                    this.val = val;
                    this.next = next;
                    this.pre = pre;
                }
            }

            Node head;
            Node tail;
            int size;

            public CustomLink() {
                head = new Node();
                tail = new Node();
                head.next = tail;
                tail.pre = head;
            }

            public void add(int val) {
                Node node = new Node(val, tail, tail.pre);
                tail.pre.next = node;
                tail.pre = node;
                size++;
            }

            public void pop(int val) {
                Node node = tail.pre;
                int cnt = 0;
                while (node != head && node.val == val) {
                    node = node.pre;
                    cnt++;
                }
                head.next = node.next;
                node.next.pre = head;
                size = cnt;
            }

            int size() {
                return size;
            }

        }

        public int totalFruit(int[] fruits) {
            CustomLink queue = new CustomLink();
            int f1 = fruits[0];
            int f2 = 0;
            queue.add(fruits[0]);
            int i = 1;
            for (; i < fruits.length; i++) {
                if (fruits[i] != f1) {
                    f2 = fruits[i];
                    queue.add(f2);
                    i++;
                    break;
                }
                queue.add(fruits[i]);
            }
            int ans = queue.size();
            for (; i < fruits.length; i++) {
                int fruit = fruits[i];
                if (fruit != f1 && fruit != f2) {
                    int pre = fruits[i - 1];
                    if (pre == f1) {
                        f2 = fruit;
                    } else {
                        f1 = fruit;
                    }
                    queue.pop(pre);
                    queue.add(fruit);
                    continue;
                }
                queue.add(fruit);
                ans = Math.max(ans, queue.size());
            }
            return ans;
        }

    }

    static class Impl {

        public int totalFruit(int[] fruits) {
            int max = 0;
            //位置1当前已使用的值
            int use1 = -1;
            //位置2当前已使用的值
            int use2 = -1;
            //位置1使用的值的个数
            int cnt1 = 0;
            //位置2使用的值的个数
            int cnt2 = 0;
            //位置1最后的索引
            int index1 = -1;
            //位置2最后的索引
            int index2 = -1;
            for (int i = 0; i < fruits.length; i++) {
                int fruit = fruits[i];

                if (use1 == fruit) {
                    cnt1++;
                    index1 = i;
                } else if (use2 == fruit) {
                    cnt2++;
                    index2 = i;
                } else {
                    //位置1和位置2谁的索引更靠近前就废弃谁
                    if (index2 < index1) {
                        //因为位置2废弃了,假设数组是(12213)，位置1之前是1，位置2之前是2，现在位置2的值要改为3，还需要更新位置1的数量
                        if (use2 != -1) {
                            cnt1 = index1 - index2;
                        }
                        use2 = fruit;
                        cnt2 = 1;
                        index2 = i;
                    } else {
                        cnt2 = index2 - index1;
                        use1 = fruit;
                        cnt1 = 1;
                        index1 = i;
                    }
                }
                max = Math.max(max, cnt1 + cnt2);
            }
            return max;
        }

    }


}
