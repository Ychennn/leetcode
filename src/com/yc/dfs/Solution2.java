package com.yc.dfs;


public class Solution2 {//二叉树的深度

    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return maxDepth;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(depth, maxDepth);
            return;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    public int maxDepth2(TreeNode root) {//优化版
        if (root == null) return 0;
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode right = new TreeNode(2);
        right.left = null;
        right.right = new TreeNode(3);
        root.right = right;
        int i = solution2.maxDepth(root);
        System.out.println(i);
    }
}
