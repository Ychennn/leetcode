package com.yc.dpointer;

public class Solution7 {//返回倒数第k个节点⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int kthToLast(ListNode head, int k) {//双指针
        ListNode h1 = head;

        //先让h1指针往前移动k位,此时两个指针相距为k
        //再同时移动两个指针,直至h1到达链表的最后一个节点
        //此时head就为倒数的第k个节点
        for (int i = 0; i < k; i++) {
            h1 = h1.next;
        }

        while (h1 != null) {
            h1 = h1.next;
            head = head.next;
        }

        return head.val;
    }
}
