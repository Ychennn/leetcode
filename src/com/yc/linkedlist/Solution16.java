package com.yc.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Solution16 {//重排链表⭐⭐⭐⭐

    public void reorderList(ListNode head) {//ArrayList
        if (head == null || head.next == null) return;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        //左右索引
        int l = 0, r = list.size() - 1;
        while (l < r) {
            list.get(l).next = list.get(r);
            l++;
            list.get(r).next = list.get(l);
            r--;
        }
        list.get(l).next = null;//此时中间的点仍指向下一个节点,应释放掉,否则会成环
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        solution16.reorderList(head);
        System.out.println(head);
    }
}
