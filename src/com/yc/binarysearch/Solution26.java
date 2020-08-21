package com.yc.binarysearch;

public class Solution26 {//完全二叉树的节点个数⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int countNodes(TreeNode root) {//用到了二分的思想
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == right) {
            //如果左右子树高度相同,说明左子树为满二叉树,左子树的节点数加根节点就等于1 << left
            //最终结果就为countNodes(root.right) + (1 << left);
            return countNodes(root.right) + (1 << left);
        } else {
            //同理
            return countNodes(root.left) + (1 << right);
        }
    }

    //递归求解树的高度,因为为完全二叉树,所以只用递归求解左子树高度
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return getHeight(root.left) + 1;
    }

    public int countNodes2(TreeNode root) {//递归求解,但没有利用到完全二叉树的特性
        if (root == null) return 0;
        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }
}
