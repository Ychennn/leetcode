package com.yc.linkedlist;

public class Solution8 {//删除排序链表中的重复元素

    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        ListNode pre = null;

        while (head != null) {
            if (pre != null && pre.val == head.val) {
                pre.next = pre.next.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode node = solution8.deleteDuplicates(head);
        System.out.println(node);
    }
}
