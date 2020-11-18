package com.yc.linkedlist;

import java.util.HashMap;

public class Solution25 {//从链表中删去总和值为零的连续节点⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public ListNode removeZeroSumSublists(ListNode head) {//前缀和
        if (head == null) return null;//特殊判断

        int sum = 0;
        //哑节点,代表不选节点的前缀和即0
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //map用来存放前缀和和当前节点
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode cur = dummy;
        while (cur != null) {
            //重复的值会被覆盖掉
            map.put(sum += cur.val, cur);
            cur = cur.next;
        }

        sum = 0;//画图
        cur = dummy;
        while (cur != null) {
            sum += cur.val;
            //当2个节点前缀和的值相等,说明2点中间的节点的值之和为零,全部删掉
            cur.next = map.get(sum).next;
            //指针指向下一个节点
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(-3);
        head.next.next.next.next = new ListNode(4);
        ListNode node = solution25.removeZeroSumSublists(head);
        System.out.println(node);
    }
}
