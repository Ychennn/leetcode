package com.yc.dfs;

public class Solution17 {//找树左下角的值
    private int maxDphth;
    private int result;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return result;
    }

    private void dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            result = depth > maxDphth ? root.val : result;
            maxDphth = Math.max(depth, maxDphth);
            return;
        }

        if (root.left != null) dfs(root.left, depth + 1);
        if (root.right != null) dfs(root.right, depth + 1);
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        int value = solution17.findBottomLeftValue(root);
        System.out.println(value);
    }
}
