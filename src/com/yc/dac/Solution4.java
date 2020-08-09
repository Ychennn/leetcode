package com.yc.dac;

public class Solution4 {//合并两个排序的链表⭐⭐⭐⭐⭐⭐⭐⭐⭐

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode curr = tmp;

        while (l1 != null && l2 != null) {//当l1或l2为空时,退出循环
            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }

        //当l1剩余的链表为空时,curr.next指向l2剩余的链表(l2可能也为空)
        curr.next = l1 != null ? l1 : l2;
        return tmp.next;
    }
}