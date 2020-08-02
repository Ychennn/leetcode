package com.yc.dfs;

import java.util.ArrayList;
import java.util.List;

public class Solution31 {//二叉树的锯齿形层次遍历⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {//dfs
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode node, List<List<Integer>> result, int depth) {
        if (node == null) return;
        depth += 1;

        if (depth == result.size() + 1) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }

        List<Integer> list = result.get(depth - 1);

        if (depth % 2 == 0) {
            list.add(0, node.val);
        } else {
            list.add(node.val);
        }

        dfs(node.left, result, depth);
        dfs(node.right, result, depth);
    }

    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        List<List<Integer>> lists = solution31.zigzagLevelOrder(root);
        System.out.println(lists);
    }
}
