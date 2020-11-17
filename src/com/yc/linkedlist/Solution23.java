package com.yc.linkedlist;

public class Solution23 {//排序链表⭐⭐⭐⭐⭐

    public ListNode sortList(ListNode head) {//归并⭐⭐⭐⭐⭐⭐
        if (head == null || head.next == null) return head;

        ListNode slow = head;//慢指针
        ListNode fast = head.next;//快指针

        while (fast != null && fast.next != null) {//找到链表的中心处
            slow = slow.next;
            fast = fast.next.next;
        }

        //将链表断开为前后连部分
        ListNode rightHead = slow.next;
        slow.next = null;//断开链表

        ListNode left = sortList(head);//递归前半部分
        ListNode right = sortList(rightHead);//递归后半部分
        return merge(left, right);//将2个有序链表合并
    }

    public ListNode merge(ListNode l1, ListNode l2) {//合并两个有序链表
        ListNode dummy = new ListNode(0);//哑节点
        ListNode tmp = dummy;//哑指针
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tmp.next = l2;
                l2 = l2.next;
            } else {
                tmp.next = l1;
                l1 = l1.next;
            }
            tmp = tmp.next;
        }
        tmp.next = (l1 == null ? l2 : l1);
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        ListNode sortList = solution23.sortList(head);
        System.out.println(sortList);
    }
}
