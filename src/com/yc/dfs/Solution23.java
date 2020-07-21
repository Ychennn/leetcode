package com.yc.dfs;

public class Solution23 {//填充每个节点的下一个右侧节点指针⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", next=" + next +
                    '}';
        }
    }

    public Node connect(Node root) {
        Node parent = new Node();
        parent.left = root;
        dfs(root, parent);
        return root;
    }

    private void dfs(Node node, Node parent) {
        if (node == null) return;//终止条件

        if (node == parent.left) {
            node.next = parent.right;
        } else {
            node.next = parent.next == null ? null : parent.next.left;
        }

        parent = node;

        dfs(node.left, parent);//左递归

        dfs(node.right, parent);//右递归
    }


    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        Node root = new Node();
        root.val = 1;
        Node left = new Node();
        left.val = 2;
        Node right = new Node();
        right.val = 3;
        root.left = left;
        root.right = right;
        Node connect = solution23.connect(root);
        System.out.println(connect);
    }
}
