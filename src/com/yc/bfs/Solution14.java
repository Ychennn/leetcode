package com.yc.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution14 {//二叉树的右视图


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int qsize = queue.size();

            for (int i = 0; i < qsize; i++) {
                TreeNode node = queue.poll();
                if (i == 0) result.add(node.val);

                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        left.left = new TreeNode(0);
        root.left = left;
        List<Integer> view = solution14.rightSideView(root);
        System.out.println(view);
    }
}
