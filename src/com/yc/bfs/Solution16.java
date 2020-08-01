package com.yc.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution16 {//在每个树行中找最大值

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(max);
        }
        return result;
    }
}
