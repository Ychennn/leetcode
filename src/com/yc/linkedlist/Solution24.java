package com.yc.linkedlist;

public class Solution24 {//二叉树中的链表⭐⭐⭐⭐⭐⭐⭐⭐

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        //先判断当前的节点,如果不对,再看左子树和右子树
        return helper(head, root) || helper(head, root.left) || helper(head, root.right);
    }

    private boolean helper(ListNode head, TreeNode root) {//从isSubPath给定值相等的节点,进行后续判断
        //链表走完了,返回true
        if (head == null) return true;
        //链表没走完,树走完了,返回false
        if (root == null) return false;

        if (head.val != root.val) return false;
        //如果当前节点值相等,递归向下处理,即head.next和当前root的左右节点
        return helper(head.next, root.left) || helper(head.next, root.right);
    }
}
