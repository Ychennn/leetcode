package com.yc.dfs;

import java.util.ArrayList;
import java.util.List;

public class Solution28 {//二叉树的右视图⭐⭐⭐⭐⭐⭐⭐⭐⭐
    private List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return result;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        depth += 1;

        //当第一次来到depth深度时,将node.val值加入list中
        if (depth == result.size() + 1) {
            result.add(node.val);
        }

        //递归先向右遍历
        dfs(node.right, depth);
        //递归再向左遍历
        dfs(node.left, depth);
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        List<Integer> list = solution28.rightSideView(root);
        System.out.println(list);
    }
}
