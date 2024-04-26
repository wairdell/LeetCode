package com.wairdell.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date   : 2024/4/26 21:35
 * desc   : 克隆图 https://leetcode.cn/problems/clone-graph/
 */
public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        return cloneGraph(node, new HashMap<>());
    }

    public Node cloneGraph(Node node, Map<Integer, Node> cloneMap) {
        if (node == null) return null;
        if (cloneMap.containsKey(node.val)) return cloneMap.get(node.val);
        Node cloneNode = new Node();
        cloneNode.val = node.val;
        cloneMap.put(node.val, cloneNode);
        if (node.neighbors != null) {
            cloneNode.neighbors = new ArrayList<>();
            for (Node neighbor : node.neighbors) {
                cloneNode.neighbors.add(cloneGraph(neighbor, cloneMap));
            }
        }
        return cloneNode;
    }

}
