package com.yc.dpointer;

public class Solution15 {//删除链表的倒数第N个节点⭐⭐⭐⭐⭐⭐⭐⭐

    //本质是找到要删除结点的前一个节点,但如果是删除头结点
    //则不存在前一个节点,所以巧妙的用“哑结点”来解决
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p1 = pre;
        ListNode p2 = pre;

        while (n > 0) {
            p1 = p1.next;
            n--;
        }

        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;

        return pre.next;
    }
}
