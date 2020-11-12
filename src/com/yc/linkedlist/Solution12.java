package com.yc.linkedlist;

public class Solution12 {//旋转链表⭐⭐⭐⭐⭐

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        int len = 1;
        while (fast.next != null) {
            len++;
            fast = fast.next;
        }

        fast.next = head;//首尾相连,形成闭环
        int step = len - k % len - 1;
        while (step-- > 0) {
            slow = slow.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }
}