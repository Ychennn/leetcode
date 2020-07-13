package com.yc.dfs;

import java.util.List;

public class Solution5 {//N叉树的最大深度⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    class Node {
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

    int maxDepth = 0;

    public int maxDepth(Node root) {//方法一
        dfs(root, 1);
        return maxDepth;
    }

    public void dfs(Node root, int depth) {
        if (root == null) return;

        maxDepth = Math.max(depth, maxDepth);

        for (Node child : root.children) {
            dfs(child, depth + 1);
        }
    }

    public int maxDepth2(Node root) {//方法二
        if (root == null) return 0;
        //求出每个子树的最大深度
        int max = 0;
        for (Node node : root.children) {
            int depth = maxDepth2(node);
            max = Math.max(max, depth);
        }
        return max + 1;//最大深度加当前节点--->+1
    }
}
