package com.yc.bfs;

import java.util.*;

public class Solution2 {//从上到下打印二叉树2

    public List<List<Integer>> levelOrder(TreeNode root) {//bfs
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            for (int i = queue.size(); i >0; i--) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;
        List<List<Integer>> lists = solution2.levelOrder(root);
        System.out.println(lists);
    }
}
