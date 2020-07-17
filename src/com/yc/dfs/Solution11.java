package com.yc.dfs;

public class Solution11 {//二叉树的最小深度⭐⭐⭐⭐⭐⭐⭐⭐⭐

    private int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return min;
    }

    private void dfs(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            min = Math.min(depth, min);
            return;
        }

        if (node.left != null) dfs(node.left, depth + 1);
        if (node.right != null) dfs(node.right, depth + 1);
    }

    //当node节点左右子节点都为空时,返回 1
    //当node节点左右子节点有一个为空时,返回不为空的子节点的深度
    //当node节点左右子节点都不为空时,返回左右子节点较小深度的节点值
    //1,2情况共用left + right + 1
    public int minDepth2(TreeNode node) {//简洁版
        if (node == null) return 0;
        int left = minDepth2(node.left);
        int right = minDepth2(node.right);

        return node.left == null || node.right == null ? left + right + 1 : Math.min(left, right) + 1;
    }


    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int i = solution11.minDepth2(root);
        System.out.println(i);
    }
}
