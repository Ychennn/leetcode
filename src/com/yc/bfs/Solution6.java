package com.yc.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution6 {//二叉树的堂兄弟⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {//bfs
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            boolean isX = false;//标记是否再该层
            boolean isY = false;//标记是否再该层

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();

                if (node.val == x) isX = true;
                if (node.val == y) isY = true;

                //如root节点,在第一层进行了该判断,满足条件返回false,实际上就相当于上一层对该层的处理
                if (node.left != null && node.right != null) {
                    if (node.left.val == x && node.right.val == y || node.left.val == y && node.right.val == x) {
                        return false;
                    }
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            //如果两个节点在同一层就返回true
            if (isX && isY) return true;
        }
        //循环结束仍未提前返回,则返回false
        return false;
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        boolean b = solution6.isCousins(root, 2, 4);
        System.out.println(b);
    }
}
