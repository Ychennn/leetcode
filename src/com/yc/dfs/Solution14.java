package com.yc.dfs;

public class Solution14 {//从前序与中序遍历序列构造二叉树⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preLeft, int preRight,
                                     int[] inorder, int inLeft, int inRight) {

        //递归终止条件
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        int rootVal = preorder[preLeft];
        int rootIndex = inLeft;
        while (inorder[rootIndex] != rootVal) {
            rootIndex++;
        }

        TreeNode root = new TreeNode(rootVal);

        root.left = buildTreeHelper(preorder, preLeft + 1, preLeft + rootIndex - inLeft, inorder, inLeft, rootIndex);
        root.right = buildTreeHelper(preorder, preLeft + rootIndex - inLeft + 1, preRight, inorder, rootIndex + 1, inRight);

        return root;
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] ineorder = {9, 3, 15, 20, 7};
        TreeNode root = solution14.buildTree(preorder, ineorder);
        System.out.println(root);
    }
}
