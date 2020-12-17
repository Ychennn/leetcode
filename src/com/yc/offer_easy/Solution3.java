package com.yc.offer_easy;

public class Solution3 {//二叉树的镜像⭐⭐⭐⭐

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
