package com.yc.linkedlist;

public class Solution17 {//删除排序链表中的重复元素2⭐⭐⭐⭐⭐⭐

    public ListNode deleteDuplicates(ListNode head) {//双指针
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);//因为头节点可能被删除掉,所以必须设置哑节点
        dummy.next = head;

        ListNode p1 = dummy;//双指针
        ListNode p2 = head;//也可以将p2初始指向head.next,但需更改代码
        //因为1个指向哑节点,一个指向头节点,是无法直接比较val的,比较p.next.val
        while (p2 != null && p2.next != null) {
            if (p1.next.val != p2.next.val) {
                p1 = p1.next;
            } else {
                while (p2.next != null && p2.next.val == p1.next.val) {
                    p2 = p2.next;
                }
                p1.next = p2.next;
            }
            p2 = p2.next;//无论作何处理,p2都应指向下一个节点
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode node = solution17.deleteDuplicates(head);
        System.out.println(node);
    }
}
