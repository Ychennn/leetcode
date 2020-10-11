package com.yc.bit;

public class Solution10 {//二进制链表转整数⭐⭐⭐⭐⭐⭐⭐⭐

   public static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = (res << 1) + head.val;
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        int i = solution10.getDecimalValue(head);
        System.out.println(i);
    }
}
