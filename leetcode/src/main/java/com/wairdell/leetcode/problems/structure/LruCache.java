package com.wairdell.leetcode.problems.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * date   : 2024/4/24 18:03
 * desc   :  LRU 缓存 https://leetcode.cn/problems/lru-cache
 */
public class LruCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2, 6);
        System.out.println(lruCache.get(1));
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

    }

    static class LRUCache {

        class Node {
            int key;
            int val;
            Node pre;
            Node next;
        }

        private int capacity;
        private Map<Integer, Node> map;
        private Node head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new Node();
            tail = new Node();

            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;

            Node node = map.get(key);
            insertToFirst(node);
            return node.val;
        }

        private void insertToFirst(Node node) {
            Node preNode = node.pre;
            node.next.pre = preNode;
            preNode.next = node.next;

            Node headNext = head.next;
            node.next = headNext;
            headNext.pre = node;

            head.next = node;
            node.pre = head;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                insertToFirst(node);
                return;
            }
            if (map.size() + 1 > capacity) {
                Node lastNode = tail.pre;
                map.remove(lastNode.key);
                lastNode.pre.next = tail;
                tail.pre = lastNode.pre;
            }
            Node node = new Node();
            node.key = key;
            node.val = value;
            addNode(node);
            map.put(key, node);

        }

        private void addNode(Node node) {
            Node nextNode = head.next;

            node.next = nextNode;
            nextNode.pre = node;

            head.next = node;
            node.pre = head;
        }

    }

//    class LRUCache {
//
//        private final int capacity;
//        private LinkedHashMap<Integer, Integer> map;
//        private Deque<Integer> deque = new ArrayDeque<>();
//
//        public LRUCache(int capacity) {
//            this.capacity = capacity;
//            map = new LinkedHashMap<>(capacity);
//        }
//
//        public int get(int key) {
//            if (map.containsKey(key)) {
//                deque.remove(key);
//                deque.addFirst(key);
//                return map.get(key);
//            }
//            return -1;
//        }
//
//        public void put(int key, int value) {
//            if (map.containsKey(key)) {
//                deque.remove(key);
//                deque.addFirst(key);
//                map.put(key, value);
//                return;
//            }
//            if (map.size() + 1 > capacity) {
//                map.remove(deque.removeLast());
//            }
//            map.put(key, value);
//            deque.addFirst(key);
//        }
//    }

}
