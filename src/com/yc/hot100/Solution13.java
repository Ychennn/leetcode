package com.yc.hot100;

public class Solution13 {//二叉树的最近公共祖先⭐⭐⭐⭐⭐

    //该函数的功能为p,q同时存在则返回最近的公共祖先
    //如果只存在一个,则返回存在的一个
    //如果p和q都不存在,则返回NULL
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) return null;//同时不存在,按题意返回null
        if (left == null) return right;
        if (right == null) return left;
        return root;//如果存在则返回当前root,即为最近的公共祖先
        //不会因为回到递归上一层而改变root的值,因为root!=null,而另一边此时肯定为null
        //(此时root已经为公共祖先,另一边肯定是找不到公共祖先的),返回不为null的一个即root
    }
}
