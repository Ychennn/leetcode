package com.yc.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {//链表的中间结点⭐⭐⭐⭐⭐

    public ListNode middleNode(ListNode head) {//list,效率低
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() / 2);
    }

    public ListNode middleNode2(ListNode head) {//快慢指针
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
