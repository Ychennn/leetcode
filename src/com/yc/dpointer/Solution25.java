package com.yc.dpointer;

public class Solution25 {//环形链表2⭐⭐⭐⭐⭐⭐⭐
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(0);
        node2.next = node3;
        ListNode node4 = new ListNode(-4);
        node3.next = node4;
        node4.next = node2;
        ListNode res = solution25.detectCycle(head);
        System.out.println(res.val);
    }
}
