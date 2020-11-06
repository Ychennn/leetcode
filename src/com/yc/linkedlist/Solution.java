package com.yc.linkedlist;

public class Solution {//合并两个有序链表⭐⭐⭐⭐⭐⭐

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode res = tmp;//指针

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l1 == null ? l2 : l1;
        return res.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {//递归,更简洁⭐⭐⭐⭐⭐⭐
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);
        ListNode node = solution.mergeTwoLists2(l1, l2);
        System.out.println(node);
    }
}