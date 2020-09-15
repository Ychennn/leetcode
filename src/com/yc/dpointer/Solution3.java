package com.yc.dpointer;

public class Solution3 {//环形链表⭐⭐⭐⭐⭐⭐

    //该题也可以用set集合来解,但效率低,而且要注意的是
    //set应添加ListNode而不是ListNode.val,val值可能发生重复

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
