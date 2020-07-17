package com.yc.dfs;

public class Solution13 {//二叉树展开为链表⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public void flatten(TreeNode root) {//需和Solution12的第二种解法区分开
        if (root == null) return;

        //将根节点的左子树变成链表
        flatten(root.left);
        //将根节点的右子树变成链表
        flatten(root.right);
        //保存右边的链表
        TreeNode tmp = root.right;
        //把树的右边换成左边的链表
        root.right = root.left;
        //把树的左边置空
        root.left = null;
        //递归地找出树的最右边的节点
        while (root.right != null) root = root.right;
        //把右边的链表拼接到刚才树的最右边的节点
        root.right = tmp;
    }


    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        solution13.flatten(root);
        System.out.println(root);
    }
}
