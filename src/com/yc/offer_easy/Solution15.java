package com.yc.offer_easy;

public class Solution15 {//对称的二叉树⭐⭐⭐⭐

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;//同时为空,肯定对称

        if (left == null || right == null//不同时为空或2个节点值不相等,不对称返回false
                || left.val == right.val) return false;

        //递归判断自己的子树
        return helper(left.right, right.left) && helper(left.left, right.right);
    }
}
