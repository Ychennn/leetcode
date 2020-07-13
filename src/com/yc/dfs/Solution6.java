package com.yc.dfs;

public class Solution6 {//路径总和⭐⭐⭐⭐⭐⭐⭐⭐

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return dfs(root, sum, 0);
    }


    private boolean dfs(TreeNode node, int sum, int curr) {
        curr += node.val;

        if (node.left == null && node.right == null) {
            if (curr == sum) return true;
            else return false;
        }

        boolean left = false;
        boolean right = false;
        if (node.left != null) left = dfs(node.left, sum, curr);
        if (node.right != null) right = dfs(node.right, sum, curr);
        return left || right;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {//更简洁
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }


    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;
        boolean b = solution6.hasPathSum2(root, 3);
        System.out.println(b);
    }
}
