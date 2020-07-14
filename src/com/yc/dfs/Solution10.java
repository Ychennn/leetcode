package com.yc.dfs;


public class Solution10 {//对称二叉树⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        //当前节点同时为空返回true
        if (left == null && right == null) return true;
        //当前节点不同时为空则返回false
        if (left == null || right == null) return false;

        //比较当前两节点值的大小,并递归比较左右节点是否对称
        return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    //不能使用中序遍历来解决该题,因为中序遍历不能确定唯一的树,如{1,2,2,2,null,2};
}
