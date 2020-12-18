package com.yc.offer_easy;

public class Solution9 {//二叉搜索树的最近公共祖先2⭐⭐⭐⭐⭐⭐⭐

    //不再为二叉搜索树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果当前节点为空,返回null
        //如果root==p返回root,因为p为p的祖先,q同理
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //同时为空:说明root的左,右子树中都不包含p,q,返回null
        if (left == null && right == null) return null;

        //left为空,right不为空
        //1->p,q其中一个在root的右子树中,此时right指向p
        //2->p,q两节点都在root的右子树中,此时的right指向最近公共祖先节点
        if (left == null) return right;

        if (right == null) return left;//同理

        return root;//都不为空,说明p,q在root的2侧
    }
}