package com.yc.offer_medium;

public class Solution7 {//树的子结构⭐⭐⭐⭐⭐

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        //先从根节点判断B是不是A的子结构,如果不是则分别从左右两个子树判断
        //只要有一个为true,就说明B是A的子结构
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode A, TreeNode B) {
        //如果B为空,说明B已经访问完了,确定是A的子结构
        if (B == null) return true;

        //如果B不为空A为空,或者这两个节点值不同,直接返回false
        if (A == null || A.val != B.val) return false;

        //判断完当前节点之后继续判断左右子节点
        return helper(A.left, B.left) && helper(A.right, B.right);
    }
}
