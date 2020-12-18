package com.yc.offer_easy;

public class Solution8 {//二叉搜索树的最近公共祖先⭐⭐⭐⭐⭐⭐⭐

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {//迭代(已优化)
        if (p.val > q.val) {//优化部分,使得p.val<q.val
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while (root != null) {
            //如果roo.val < p.val即root同时小于p,q.val
            //p,q肯定同时在root的右子树上
            if (root.val < p.val) {
                root = root.right;
            } else if (root.val > q.val) {//同理
                root = root.left;
            } else break;
        }
        return root;
    }

    //题目规定树为二叉搜索树,且p,q均存在于root中
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {//递归
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
