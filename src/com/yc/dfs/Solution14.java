package com.yc.dfs;

public class Solution14 {//从前序与中序遍历序列构造二叉树⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end,
                                     int[] inorder, int i_start, int i_end) {

        if (p_start == p_end) {
            return null;
        }

        int root_val = preorder[p_start];
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (inorder[i] == root_val) {
                i_root_index = i;
                break;
            }
        }

        int left = i_root_index - i_start;
        TreeNode root = new TreeNode(root_val);

        root.left = buildTreeHelper(preorder, p_start + 1, p_start + left + 1, inorder, i_start, i_root_index);
        root.right = buildTreeHelper(preorder, p_start + left + 1, p_end, inorder, i_root_index + 1, i_end);

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
