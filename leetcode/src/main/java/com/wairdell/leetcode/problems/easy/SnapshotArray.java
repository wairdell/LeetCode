package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/26 9:38
 * desc   : 快照数组 https://leetcode.cn/problems/snapshot-array
 */
public class SnapshotArray {

    public static void main(String[] args) {
        SnapshotArray snapshot = new SnapshotArray(4);

        /*snapshot.set(0, 5);
        int snapId = snapshot.snap();
        snapshot.set(0, 6);
        System.out.println(snapshot.get(0, snapId));*/
        System.out.println(snapshot.snap());
        System.out.println(snapshot.snap());
        System.out.println(snapshot.get(3, 1));
        snapshot.set(2, 4);
        System.out.println(snapshot.snap());
        snapshot.set(1, 4);
    }

    public static class Node {

        private int val;
        private int snap;
        private Node next;

        public Node(int val, int snap) {
            this.val = val;
            this.snap = snap;
        }

    }

    private int snapId;
    private Node[] nodes;

    public SnapshotArray(int length) {
        nodes = new Node[length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(0, snapId);
        }
    }

    public void set(int index, int val) {
        Node node = nodes[index];
        if (node.snap == snapId) {
            node.val = val;
        } else {
            Node newestNode = new Node(val, snapId);
            newestNode.next = node;
            nodes[index] = newestNode;
        }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        Node node = nodes[index];
        while (node.snap > snap_id) {
            node = node.next;
        }
        return node.val;
    }

}
