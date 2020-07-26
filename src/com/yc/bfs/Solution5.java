package com.yc.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution5 {//N叉树的最大深度

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {//bfs
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Node node = queue.poll();

                for (Node child : node.children) {
                    queue.add(child);
                }
            }
            max++;
        }
        return max;
    }
}
