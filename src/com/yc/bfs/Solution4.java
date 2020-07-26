package com.yc.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {//对称二叉树⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public boolean isSymmetric(TreeNode root) {//bfs
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) continue;

            if (left == null || right == null) return false;

            if (left.val != right.val) return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(3);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        boolean b = solution4.isSymmetric(root);
        System.out.println(b);
    }
}
