package com.yc.dpointer;

public class Solution17 {//分隔链表⭐⭐⭐⭐⭐⭐⭐⭐

    public ListNode partition(ListNode head, int x) {
        ListNode minLink = new ListNode(0);//记录较小值链表的头
        ListNode minP = minLink;

        ListNode maxLink = new ListNode(0);//记录较大值链表的头
        ListNode maxP = maxLink;

        while (head != null) {
            if (head.val < x) {//找到较小值
                minP.next = head;//放入minLink中，操作指针后移一位
                minP = minP.next;
            } else {//找到较大值
                maxP.next = head;//放入maxLink中，操作指针后移一位
                maxP = maxP.next;
            }

            head = head.next;
        }

        //{1,3,5,6,2},假设 x=3,则可得到两个链表分别是{1,2}和{3,5,6}
        //但此时右链表的尾部,即6的尾部仍指向2,如果不把右链表的尾部置为null
        //最后就会得到 1->2->3->5->6->2这个链表,在节点2处成环
        //因此必须将右链表尾部手动置为None,实现断链,最后得到 1->2->3->5->6->None
        maxP.next = null;

        //两段拼接
        minP.next = maxLink.next;
        return minLink.next;
    }
}
