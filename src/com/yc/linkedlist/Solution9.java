package com.yc.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Solution9 {//移除重复节点

    public ListNode removeDuplicateNodes(ListNode head) {//Hash表
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;//没有使用pre节点来删除节点
        while (cur != null && cur.next != null) {//防止提供的head为空
            set.add(cur.val);//画图
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        ListNode node = solution9.removeDuplicateNodes(head);
        System.out.println(node);
    }
}
