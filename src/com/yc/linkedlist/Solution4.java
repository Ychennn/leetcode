package com.yc.linkedlist;

public class Solution4 {//移除链表元素⭐⭐⭐⭐⭐⭐

    public ListNode removeElements2(ListNode head, int val) {//哑节点法
        ListNode tmp = new ListNode(0);
        tmp.next = head;

        ListNode pre = tmp;//和Solution4不一样,该题移除多个元素
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return tmp.next;
    }

    public ListNode removeElements(ListNode head, int val) {//递归法⭐⭐⭐⭐⭐
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        ListNode root = solution4.removeElements(head, 1);
        System.out.println(root);
    }
}
