package com.yc.linkedlist;

public class Solution12 {//旋转链表⭐⭐⭐⭐⭐

    public ListNode rotateRight(ListNode head, int k) {//双指针
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        int len = 1;//统计链表长度,计算移动步数
        while (fast.next != null) {//fast移动到最后一个节点
            len++;
            fast = fast.next;
        }

        fast.next = head;//首尾相连,形成闭环
        int step = len - k % len - 1;//移动步数,画图
        while (step-- > 0) {//slow移动至断开位置
            slow = slow.next;
        }
        //断开链表
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }
}