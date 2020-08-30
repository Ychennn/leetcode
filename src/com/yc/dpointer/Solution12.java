package com.yc.dpointer;

public class Solution12 {//回文链表

    public boolean isPalindrome(ListNode head) {//未使用双指针
        if (head == null || head.next == null) return true;
        int[] res = new int[100001];
        int index = 0;
        while (head != null) {
            res[index++] = head.val;
            head = head.next;
        }

        for (int i = 0; i < index / 2; i++) {
            if (res[i] != res[index - i - 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        Solution12 solution12 = new Solution12();
        boolean b = solution12.isPalindrome(listNode);
        System.out.println(b);
    }
}
