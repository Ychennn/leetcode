package com.yc.linkedlist;

public class Solution3 {//删除链表的节点⭐⭐⭐⭐⭐⭐

    public ListNode deleteNode(ListNode head, int val) {
        ListNode tmp = new ListNode(0);//哑节点
        tmp.next = head;

        ListNode pre = tmp;//指针,指向head(当前节点)的前一个节点
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                break;
            }
            pre = head;
            head = head.next;
        }

        return tmp.next;
    }
}
