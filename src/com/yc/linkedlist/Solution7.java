package com.yc.linkedlist;

public class Solution7 {//反转链表⭐⭐⭐⭐

    public ListNode reverseList2(ListNode head) {//双指针⭐⭐⭐⭐
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            //用来保存下一个节点,因为cur.next已经更改为指向pre,不然不能进行到下一步
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {//递归⭐⭐⭐⭐
        if (head == null || head.next == null) return head;//head==null防止给的的测试head为null
        ListNode cur = reverseList(head.next);//画图
        head.next.next = head;
        head.next = null;//释放掉,否则会形成环
        return cur;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
//        root.next.next = new ListNode(3);
        ListNode node = solution7.reverseList(root);
        System.out.println(node);
    }
}
