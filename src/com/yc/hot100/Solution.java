package com.yc.hot100;

public class Solution {//合并二叉树⭐⭐⭐⭐

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {//自己的递归,效率较低
        if (t1 == null && t2 == null) return null;
        int a = (t1 == null ? 0 : t1.val);
        int b = (t2 == null ? 0 : t2.val);
        TreeNode root = new TreeNode(a + b);

        root.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        root.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return root;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {//⭐⭐⭐⭐
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
