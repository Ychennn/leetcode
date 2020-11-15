package com.yc.linkedlist;

public class Solution18 {//有序链表转换二叉搜索树⭐⭐⭐⭐⭐⭐⭐⭐

    public TreeNode sortedListToBST(ListNode head) {//快慢指针,效率高
        if (head == null) return null;//递归终止条件
        if (head.next == null) return new TreeNode(head.val);//递归终止条件

        //pre指针的作用是将链断为2条,便于后续操作
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }//最终慢指针落在链表长度的1/2处即中间

        pre.next = null;//此时pre指向slow前面的节点,将链表一分为二

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);//递归处理左右
        root.right = sortedListToBST(slow.next);
        return root;
    }

    //也可以使用list将head.val的值保存起来,然后递归解决,但效率低
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        TreeNode root = solution18.sortedListToBST(head);
        System.out.println(root);
    }
}
