package com.yc.dfs;

public class Solution18 {//从中序与后序遍历序列构造二叉树⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder,
                0, inorder.length - 1);
    }


    private TreeNode buildTreeHelper(int[] inorder, int inLeft, int inRight,
                                     int[] postorder, int postLeft, int postRight) {
        //递归终止条件
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }

        int rootVal = postorder[postRight];
        int rootIndex = inLeft;

        //注意越界
        while (inorder[rootIndex] != rootVal) {
            rootIndex++;
        }
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTreeHelper(inorder, inLeft, rootIndex - 1,
                postorder, postLeft, postRight - inRight + rootIndex - 1);

        root.right = buildTreeHelper(inorder, rootIndex + 1, inRight,
                postorder, postRight - inRight + rootIndex, postRight - 1);
        return root;
    }

    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        int[] inorder = new int[]{1, 2, 3};
        int[] postorder = new int[]{1, 3, 2};
        TreeNode root = solution18.buildTree(inorder, postorder);
        System.out.println(root);
    }
}
