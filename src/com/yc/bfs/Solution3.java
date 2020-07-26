package com.yc.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {//二叉树的最小深度⭐⭐⭐⭐⭐⭐⭐⭐⭐
    public int minDepth(TreeNode root) {//bfs
        Queue<TreeNode> queue = new LinkedList();
        int minDepth = 0;

        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            minDepth++;

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return minDepth;//叶子节点,直接返回

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return minDepth;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;
        int i = solution3.minDepth(root);
        System.out.println(i);
    }
}
