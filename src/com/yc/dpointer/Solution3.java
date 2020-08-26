package com.yc.dpointer;

public class Solution3 {//环形链表⭐⭐⭐⭐⭐⭐

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //该题也可以用set集合来解,但效率低,而且要注意的是
    //set应添加ListNode而不是ListNode.val,val值可能发生重复

    public boolean hasCycle(ListNode head) {//双指针,快慢指针
        if (head == null || head.next == null) return false;

        //不设在同一起点,是因为while循环的第一步if判断就返回了
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) return true;

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
