package com.yc.linkedlist;

public class Solution22 {//环形链表2⭐⭐⭐⭐⭐⭐

    public ListNode detectCycle(ListNode head) {//快慢指针
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        //此时可能因fast==null||fast.next==null而退出循环,并不满足slow=fast
        //判断,如果不等则直接返回null
        if (slow != fast) return null;

        slow = head;//重置slow指针为head
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }//画图
        return slow;
    }
}
