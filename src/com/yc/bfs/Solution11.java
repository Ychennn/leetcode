package com.yc.bfs;

import java.util.LinkedList;
import java.util.Queue;


public class Solution11 {//找树左下角的值

    public int findBottomLeftValue(TreeNode root) {//bfs
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            int qsize = queue.size();
            for (int i = 0; i < qsize; i++) {
                TreeNode node = queue.poll();
                if (i == 0) result = node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return result;
    }
}
