package com.yc.dfs;

public class Solution3 {//平衡二叉树⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        //递归求解根节点是否平衡
        return (Math.abs(maxDepth(root.left) - maxDepth(root.right)) < 2)
                && isBalanced(root.left) && isBalanced(root.right);
    }

    //递归求解根节点的高度
    public int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;
        boolean balanced = solution3.isBalanced(root);
        System.out.println(balanced);
    }
}
