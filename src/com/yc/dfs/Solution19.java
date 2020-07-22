package com.yc.dfs;

public class Solution19 {//打家劫舍3⭐⭐⭐⭐⭐⭐⭐⭐

    public int rob(TreeNode root) {//动态规划 + 后续遍历
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] dp = new int[2];

        //dp[0]:以当前node为根结点的子树能够偷取的最大价值,规定node结点不偷
        //dp[1]:以当前node为根结点的子树能够偷取的最大价值,规定node结点偷
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = node.val + left[0] + right[0];

        return dp;
    }

    public static void main(String[] args) {
        Solution19 solution19 =new Solution19();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        int rob = solution19.rob(root);
        System.out.println(rob);
    }
}
