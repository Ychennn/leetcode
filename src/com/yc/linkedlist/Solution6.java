package com.yc.linkedlist;

public class Solution6 {//两个链表的第一个公共节点⭐⭐⭐⭐

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {//双指针
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            //这里不能使用p1.next == null?,因为在没有交点的时候,会出现死循环,p1,p2永不相等
            //当有公共点时,则效果一样.而p1 == null?则会在p1 == p2 ==null时退出循环
            p1 = (p1.next == null) ? headB : p1.next;
            p2 = (p2.next == null) ? headA : p2.next;
        }
        return p1;//这里的公共节点是指2个链表共同指向的节点,不是单纯的值相等的节点
    }

    public static void main(String[] args) {
        ListNode common = new ListNode(1);
        common.next = new ListNode(2);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(5);
        headA.next.next = common;

        ListNode headB = new ListNode(3);
        headB.next = common;

        Solution6 solution6 = new Solution6();
        ListNode node = solution6.getIntersectionNode(headA, headB);
        System.out.println(node);
    }
}
