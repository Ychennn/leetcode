package com.yc.linkedlist;

public class Solution21 {//奇偶链表⭐⭐⭐⭐

    //题目要求原地算法
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;//奇指针
        ListNode evenHead = head.next;//偶链表的头结点,因为要拼接,evenHead是必不可少的
        ListNode even = evenHead;//偶指针
        while (even != null && even.next != null) {//画图⭐⭐⭐⭐⭐⭐
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode node = solution21.oddEvenList(head);
        System.out.println(node);
    }
}
