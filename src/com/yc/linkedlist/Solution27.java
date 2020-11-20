package com.yc.linkedlist;

public class Solution27 {//对链表进行插入排序⭐⭐⭐⭐⭐⭐

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //lastSorted维护一个指针指向已排序部分的最后一个节点,初始指向dummy.next即head
        //cur为待处理的元素,初始为head.next
        ListNode lastSorted = head, cur = head.next;
        while (cur != null) {
            if (cur.val >= lastSorted.val) {
                //如果当前节点的值>最后一个已排序的节点的值
                //即已是正确的位置,lastSorted指针后移一位
                lastSorted = lastSorted.next;
            } else {
                //初始化prev指针指向dummy
                ListNode pre = dummy;
                //循环比较prev.next.val和cur.val的值,找到对应的插入位置
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                //画图⭐⭐⭐⭐⭐⭐
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            //这一步不能是cur=cur.next,此时cur已经排好序,不在原来的位置
            cur = lastSorted.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        ListNode node = solution27.insertionSortList(head);
        System.out.println(node);
    }
}
