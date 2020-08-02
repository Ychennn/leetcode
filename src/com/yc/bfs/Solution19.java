package com.yc.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution19 {//二叉树的锯齿形层次遍历⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {//bfs
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //判断是正序或是反序
        boolean flag = true;

        while (!queue.isEmpty()) {
            //用list的添加位置来完成反转
            List<Integer> list = new ArrayList<>();

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();

                if (flag) {//如果正序,添加至末尾
                    list.add(node.val);
                } else {//否则,添加至首部
                    list.add(0, node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(list);
            flag = !flag;//标志位取反
        }
        return result;
    }

    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        List<List<Integer>> lists = solution19.zigzagLevelOrder(root);
        System.out.println(lists);
    }
}
