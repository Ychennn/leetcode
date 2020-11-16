package com.yc.linkedlist;

import java.util.Arrays;

public class Solution20 {//分割链表

    public ListNode[] splitListToParts(ListNode root, int k) {//直接原地拆分
        ListNode cur = root;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int width = len / k, rem = len % k;
        ListNode[] res = new ListNode[k];

        cur = root;
        for (int i = 0; i < k; i++) {//画图
            ListNode head = cur;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; j++) {//j的范围⭐⭐⭐⭐⭐
                if (cur != null) cur = cur.next;
            }

            if (cur != null) {
                ListNode tmp = cur;
                cur = cur.next;
                tmp.next = null;//断开分割好的链表
            }
            res[i] = head;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode[] listNodes = solution20.splitListToParts(head, 4);
        System.out.println(Arrays.toString(listNodes));
    }
}
