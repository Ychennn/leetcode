package com.yc.hot100;

public class Solution12 {//把二叉搜索树转换为累加树⭐⭐⭐⭐⭐
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode node = solution12.convertBST(root);
        System.out.println(node);
    }
}
