package com.yc.recursion;

public class Solution10 {//旋转链表⭐⭐⭐⭐⭐

    public ListNode rotateRight(ListNode head, int k) {//双指针
        if (head == null) return head;
        ListNode slow = head;//快慢指针
        ListNode fast = head;
        int len = 1;//统计链表长度,为了后面计算移动步数
        while (fast.next != null) {
            len++;//快指针最后落在链表的最后一个节点
            fast = fast.next;
        }

        fast.next = head;//首尾相连,形成闭环
        int step = len - k % len - 1;//慢指针移动的步数,最终落点为切割点的前一个节点
        while (step-- > 0) {
            slow = slow.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }
}
